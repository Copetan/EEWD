/*
 * Copyright (C) 2014 by gempa GmbH - http://gempa.de
 * License: http://www.gnu.org/licenses/gpl.html GPL version 2 or higher
 */
package org.reaktEU.ewViewer.data;

import java.util.Date;
import java.util.Objects;
import org.quakeml.xmlns.bedRt.x12.Event;
import org.quakeml.xmlns.bedRt.x12.EventParameters;
import org.quakeml.xmlns.bedRt.x12.Magnitude;
import org.quakeml.xmlns.bedRt.x12.Origin;
import org.quakeml.xmlns.bedRt.x12.RealQuantity;
import org.quakeml.xmlns.bedRt.x12.TimeQuantity;

/**
 *
 * @author Stephan Herrnkind <herrnkind@gempa.de>
 */
public class EventData {

    public class InvalidEventDataException extends Exception {

        public InvalidEventDataException() {
        }

        public InvalidEventDataException(String message) {
            super(message);
        }
    }

    public String eventID;
    public long time;
    public double latitude;
    public double longitude;
    public double depth = 0.0;
    public double magnitude = 0.0;
    public Double intensity = null;

    public EventParameters eventParameters = null;

    public EventData() {
    }

    public EventData(String id, long time, double latitude,
                     double longitude, double depth, double magnitude) {
        this.eventID = id;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.depth = depth;
        this.magnitude = magnitude;
    }

    public EventData(EventParameters eventParameters)
            throws InvalidEventDataException {

        // get event
        assertOne(eventParameters.getEventArray(), "event");
        Event event = eventParameters.getEventArray(0);
        eventID = event.getPublicID();

        // get preferred origin
        assertOne(event.getPreferredOriginIDArray(), "preferred origin");
        String preferredOriginID = event.getPreferredOriginIDArray(0);
        Origin origin = null;
        for (Origin o : eventParameters.getOriginArray()) {
            if (o.getPublicID().equals(preferredOriginID)) {
                origin = o;
                break;
            }
        }
        if (origin == null) {
            throw new InvalidEventDataException("preferred origin with id '"
                                                + preferredOriginID + "' not found");
        }

        // read origin information
        time = getTimeQuantity(origin.getTimeArray(), "time");
        latitude = getRealQuantity(origin.getLatitudeArray(), "latitude");
        longitude = getRealQuantity(origin.getLongitudeArray(), "longitude");
        depth = getRealQuantity(origin.getDepthArray(), "depth");

        // get preferred magnitude
        assertOne(event.getPreferredMagnitudeIDArray(), "preferred magnitude");
        String preferredMagnitudeID = event.getPreferredMagnitudeIDArray(0);
        Magnitude mag = null;
        for (Magnitude m : eventParameters.getMagnitudeArray()) {
            if (m.getPublicID().equals(preferredMagnitudeID)) {
                mag = m;
                break;
            }
        }
        if (mag == null) {
            throw new InvalidEventDataException("preferred magnitude with id '"
                                                + preferredMagnitudeID + "' not found");
        }
        magnitude = getRealQuantity(mag.getMagArray(), "magnitude");
    }

    private void assertOne(Object[] array, String name)
            throws InvalidEventDataException {
        if (array.length == 0) {
            throw new InvalidEventDataException("no " + name + " specifed");
        } else if (array.length > 1) {
            throw new InvalidEventDataException("more than one " + name + " specifed");
        }
    }

    private double getRealQuantity(RealQuantity[] array, String name)
            throws InvalidEventDataException {
        assertOne(array, name);
        RealQuantity quantity = array[0];
        if (quantity.getValueArray().length == 0) {
            throw new InvalidEventDataException("no " + name + " value specifed");
        } else if (quantity.getValueArray().length > 1) {
            throw new InvalidEventDataException("more than one " + name + " value specifed");
        }
        return quantity.getValueArray(0);
    }

    private long getTimeQuantity(TimeQuantity[] array, String name)
            throws InvalidEventDataException {
        assertOne(array, name);
        TimeQuantity quantity = array[0];
        if (quantity.getValueArray().length == 0) {
            throw new InvalidEventDataException("no " + name + " value specifed");
        } else if (quantity.getValueArray().length > 1) {
            throw new InvalidEventDataException("more than one " + name + " value specifed");
        }
        return quantity.getValueArray(0).getTimeInMillis();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.eventID);
        hash = 17 * hash + Objects.hashCode(this.time);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.latitude) ^ (Double.doubleToLongBits(this.latitude) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.longitude) ^ (Double.doubleToLongBits(this.longitude) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.depth) ^ (Double.doubleToLongBits(this.depth) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.magnitude) ^ (Double.doubleToLongBits(this.magnitude) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.intensity);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EventData other = (EventData) obj;
        if (!Objects.equals(this.eventID, other.eventID)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(other.latitude)) {
            return false;
        }
        if (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(other.longitude)) {
            return false;
        }
        if (Double.doubleToLongBits(this.depth) != Double.doubleToLongBits(other.depth)) {
            return false;
        }
        if (Double.doubleToLongBits(this.magnitude) != Double.doubleToLongBits(other.magnitude)) {
            return false;
        }
        return Objects.equals(this.intensity, other.intensity);
    }

    @Override
    public String toString() {
        return "EventProperties{" + "eventID=" + eventID + ", time=" + time + ", latitude=" + latitude + ", longitude=" + longitude + ", depth=" + depth + ", magnitude=" + magnitude + ", intensity=" + intensity + '}';
    }

}
