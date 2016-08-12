package org.opentripplanner.updater.car_park;

import com.fasterxml.jackson.databind.JsonNode;
import com.vividsolutions.jts.geom.*;
import org.opentripplanner.routing.car_park.CarPark;
import org.opentripplanner.util.NonLocalizedString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Load car parks from the HSL Park and Ride API.
 *
 * @author hannesj
 */
public class HslCarParkDataSource extends GenericJsonCarParkDataSource{

    private static final Logger log = LoggerFactory.getLogger(HslCarParkDataSource.class);

    private GeometryFactory gf = new GeometryFactory();

    public HslCarParkDataSource() {
        super("results");
    }

    public CarPark makeCarPark(JsonNode node) {
        if (node.path("builtCapacity").path("CAR").isMissingNode()) return null;

        CarPark station = new CarPark();
        station.id = node.path("id").asText();
        // TODO: add internalization
        station.name = new NonLocalizedString(node.path("name").path("fi").asText());
        try {
            station.geometry = parseGeometry(node.path("location"));
            station.y = station.geometry.getCentroid().getY();
            station.x = station.geometry.getCentroid().getX();
            station.realTimeData = false;
            station.maxCapacity = node.path("builtCapacity").path("CAR").asInt();
            if (!node.path("status").asText().equals("IN_OPERATION")) {
                station.spacesAvailable = 0;
            } else {
                station.spacesAvailable = station.maxCapacity;
            }
            return station;
        } catch (Exception e) {
            log.warn("Error parsing car park " + station.id, e);
            return null;
        }
    }


    // TODO: These are inlined from GeometryDeserializer
    private Geometry parseGeometry(JsonNode root) {
        String typeName = root.get("type").asText();
        if(typeName.equals("Point")) {
            return this.gf.createPoint(this.parseCoordinate(root.get("coordinates")));
        } else if(typeName.equals("MultiPoint")) {
            return this.gf.createMultiPoint(this.parseLineString(root.get("coordinates")));
        } else if(typeName.equals("LineString")) {
            return this.gf.createLineString(this.parseLineString(root.get("coordinates")));
        } else if(typeName.equals("MultiLineString")) {
            return this.gf.createMultiLineString(this.parseLineStrings(root.get("coordinates")));
        } else {
            JsonNode arrayOfPolygons;
            if(typeName.equals("Polygon")) {
                arrayOfPolygons = root.get("coordinates");
                return this.parsePolygonCoordinates(arrayOfPolygons);
            } else if(typeName.equals("MultiPolygon")) {
                arrayOfPolygons = root.get("coordinates");
                return this.gf.createMultiPolygon(this.parsePolygons(arrayOfPolygons));
            } else if(typeName.equals("GeometryCollection")) {
                return this.gf.createGeometryCollection(this.parseGeometries(root.get("geometries")));
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    private Geometry[] parseGeometries(JsonNode arrayOfGeoms) {
        Geometry[] items = new Geometry[arrayOfGeoms.size()];

        for(int i = 0; i != arrayOfGeoms.size(); ++i) {
            items[i] = this.parseGeometry(arrayOfGeoms.get(i));
        }

        return items;
    }

    private Polygon parsePolygonCoordinates(JsonNode arrayOfRings) {
        return this.gf.createPolygon(this.parseExteriorRing(arrayOfRings), this.parseInteriorRings(arrayOfRings));
    }

    private Polygon[] parsePolygons(JsonNode arrayOfPolygons) {
        Polygon[] polygons = new Polygon[arrayOfPolygons.size()];

        for(int i = 0; i != arrayOfPolygons.size(); ++i) {
            polygons[i] = this.parsePolygonCoordinates(arrayOfPolygons.get(i));
        }

        return polygons;
    }

    private LinearRing parseExteriorRing(JsonNode arrayOfRings) {
        return this.gf.createLinearRing(this.parseLineString(arrayOfRings.get(0)));
    }

    private LinearRing[] parseInteriorRings(JsonNode arrayOfRings) {
        LinearRing[] rings = new LinearRing[arrayOfRings.size() - 1];

        for(int i = 1; i < arrayOfRings.size(); ++i) {
            rings[i - 1] = this.gf.createLinearRing(this.parseLineString(arrayOfRings.get(i)));
        }

        return rings;
    }

    private Coordinate parseCoordinate(JsonNode array) {
        return new Coordinate(array.get(0).asDouble(), array.get(1).asDouble());
    }

    private Coordinate[] parseLineString(JsonNode array) {
        Coordinate[] points = new Coordinate[array.size()];

        for(int i = 0; i != array.size(); ++i) {
            points[i] = this.parseCoordinate(array.get(i));
        }

        return points;
    }

    private LineString[] parseLineStrings(JsonNode array) {
        LineString[] strings = new LineString[array.size()];

        for(int i = 0; i != array.size(); ++i) {
            strings[i] = this.gf.createLineString(this.parseLineString(array.get(i)));
        }

        return strings;
    }
}

