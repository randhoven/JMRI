package jmri.jmrix.lenz.liusbethernet.configurexml;

import jmri.InstanceManager;
import jmri.jmrix.configurexml.AbstractNetworkConnectionConfigXml;
import jmri.jmrix.lenz.liusbethernet.ConnectionConfig;
import jmri.jmrix.lenz.liusbethernet.LIUSBEthernetAdapter;

import org.jdom.Element;

/**
 * Handle XML persistance of layout connections by persistening
 * the LIUSB Server (and connections). Note this is
 * named as the XML version of a ConnectionConfig object,
 * but it's actually persisting the LIUSB Server.
 * <P>
 * NOTE: The LIUSB Server currently has no options, so this class does 
 * not store any.
 * <p>
 * This class is invoked from jmrix.JmrixConfigPaneXml on write,
 * as that class is the one actually registered. Reads are brought
 * here directly via the class attribute in the XML.
 *
 * @author   Paul Bender Copyright (C) 2009	
 * @version $Revision$
 */
public class ConnectionConfigXml extends AbstractNetworkConnectionConfigXml {

    public ConnectionConfigXml() {
        super();
    }

    @Override
    protected void getInstance() {
        if(adapter == null) adapter=new LIUSBEthernetAdapter();
    }

    @Override
    protected void getInstance(Object object) {
        adapter=((ConnectionConfig) object).getAdapter();
    }

    protected void register() {
        InstanceManager.configureManagerInstance().registerPref(new ConnectionConfig(adapter));
    }

    // initialize logging
static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ConnectionConfigXml.class.getName());

}
