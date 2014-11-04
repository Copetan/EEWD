/*
 * Copyright (C) 2014 by gempa GmbH - http://gempa.de
 * License: http://www.gnu.org/licenses/gpl.html GPL version 2 or higher
 */
package org.reaktEU.ewViewer.data;

import org.quakeml.xmlns.bedRt.x12.EventParameters;

/**
 *
 * @author Stephan Herrnkind <herrnkind@gempa.de>
 */
public interface QMLListener {

    /**
     * @param eventParameters
     * @param offset Time in milliseconds to add to the origin time. Used in
     * scenario replay and set to 0 for actual events received through
     * messaging.
     */
    void processQML(EventParameters eventParameters, long offset);
}
