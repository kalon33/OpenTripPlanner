/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.opentripplanner.api.thrift.definition;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Location implements org.apache.thrift.TBase<Location, Location._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Location");

  private static final org.apache.thrift.protocol.TField LAT_LNG_FIELD_DESC = new org.apache.thrift.protocol.TField("lat_lng", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField HEADING_FIELD_DESC = new org.apache.thrift.protocol.TField("heading", org.apache.thrift.protocol.TType.DOUBLE, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new LocationStandardSchemeFactory());
    schemes.put(TupleScheme.class, new LocationTupleSchemeFactory());
  }

  private LatLng lat_lng; // optional
  private double heading; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    LAT_LNG((short)1, "lat_lng"),
    HEADING((short)3, "heading");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // LAT_LNG
          return LAT_LNG;
        case 3: // HEADING
          return HEADING;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __HEADING_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);
  private _Fields optionals[] = {_Fields.LAT_LNG,_Fields.HEADING};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.LAT_LNG, new org.apache.thrift.meta_data.FieldMetaData("lat_lng", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, LatLng.class)));
    tmpMap.put(_Fields.HEADING, new org.apache.thrift.meta_data.FieldMetaData("heading", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Location.class, metaDataMap);
  }

  public Location() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Location(Location other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetLat_lng()) {
      this.lat_lng = new LatLng(other.lat_lng);
    }
    this.heading = other.heading;
  }

  public Location deepCopy() {
    return new Location(this);
  }

  @Override
  public void clear() {
    this.lat_lng = null;
    setHeadingIsSet(false);
    this.heading = 0.0;
  }

  public LatLng getLat_lng() {
    return this.lat_lng;
  }

  public void setLat_lng(LatLng lat_lng) {
    this.lat_lng = lat_lng;
  }

  public void unsetLat_lng() {
    this.lat_lng = null;
  }

  /** Returns true if field lat_lng is set (has been assigned a value) and false otherwise */
  public boolean isSetLat_lng() {
    return this.lat_lng != null;
  }

  public void setLat_lngIsSet(boolean value) {
    if (!value) {
      this.lat_lng = null;
    }
  }

  public double getHeading() {
    return this.heading;
  }

  public void setHeading(double heading) {
    this.heading = heading;
    setHeadingIsSet(true);
  }

  public void unsetHeading() {
    __isset_bit_vector.clear(__HEADING_ISSET_ID);
  }

  /** Returns true if field heading is set (has been assigned a value) and false otherwise */
  public boolean isSetHeading() {
    return __isset_bit_vector.get(__HEADING_ISSET_ID);
  }

  public void setHeadingIsSet(boolean value) {
    __isset_bit_vector.set(__HEADING_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case LAT_LNG:
      if (value == null) {
        unsetLat_lng();
      } else {
        setLat_lng((LatLng)value);
      }
      break;

    case HEADING:
      if (value == null) {
        unsetHeading();
      } else {
        setHeading((Double)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case LAT_LNG:
      return getLat_lng();

    case HEADING:
      return Double.valueOf(getHeading());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case LAT_LNG:
      return isSetLat_lng();
    case HEADING:
      return isSetHeading();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Location)
      return this.equals((Location)that);
    return false;
  }

  public boolean equals(Location that) {
    if (that == null)
      return false;

    boolean this_present_lat_lng = true && this.isSetLat_lng();
    boolean that_present_lat_lng = true && that.isSetLat_lng();
    if (this_present_lat_lng || that_present_lat_lng) {
      if (!(this_present_lat_lng && that_present_lat_lng))
        return false;
      if (!this.lat_lng.equals(that.lat_lng))
        return false;
    }

    boolean this_present_heading = true && this.isSetHeading();
    boolean that_present_heading = true && that.isSetHeading();
    if (this_present_heading || that_present_heading) {
      if (!(this_present_heading && that_present_heading))
        return false;
      if (this.heading != that.heading)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Location other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Location typedOther = (Location)other;

    lastComparison = Boolean.valueOf(isSetLat_lng()).compareTo(typedOther.isSetLat_lng());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLat_lng()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lat_lng, typedOther.lat_lng);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHeading()).compareTo(typedOther.isSetHeading());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHeading()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.heading, typedOther.heading);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Location(");
    boolean first = true;

    if (isSetLat_lng()) {
      sb.append("lat_lng:");
      if (this.lat_lng == null) {
        sb.append("null");
      } else {
        sb.append(this.lat_lng);
      }
      first = false;
    }
    if (isSetHeading()) {
      if (!first) sb.append(", ");
      sb.append("heading:");
      sb.append(this.heading);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class LocationStandardSchemeFactory implements SchemeFactory {
    public LocationStandardScheme getScheme() {
      return new LocationStandardScheme();
    }
  }

  private static class LocationStandardScheme extends StandardScheme<Location> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Location struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // LAT_LNG
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.lat_lng = new LatLng();
              struct.lat_lng.read(iprot);
              struct.setLat_lngIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // HEADING
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.heading = iprot.readDouble();
              struct.setHeadingIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Location struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.lat_lng != null) {
        if (struct.isSetLat_lng()) {
          oprot.writeFieldBegin(LAT_LNG_FIELD_DESC);
          struct.lat_lng.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetHeading()) {
        oprot.writeFieldBegin(HEADING_FIELD_DESC);
        oprot.writeDouble(struct.heading);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class LocationTupleSchemeFactory implements SchemeFactory {
    public LocationTupleScheme getScheme() {
      return new LocationTupleScheme();
    }
  }

  private static class LocationTupleScheme extends TupleScheme<Location> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Location struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetLat_lng()) {
        optionals.set(0);
      }
      if (struct.isSetHeading()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetLat_lng()) {
        struct.lat_lng.write(oprot);
      }
      if (struct.isSetHeading()) {
        oprot.writeDouble(struct.heading);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Location struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.lat_lng = new LatLng();
        struct.lat_lng.read(iprot);
        struct.setLat_lngIsSet(true);
      }
      if (incoming.get(1)) {
        struct.heading = iprot.readDouble();
        struct.setHeadingIsSet(true);
      }
    }
  }

}
