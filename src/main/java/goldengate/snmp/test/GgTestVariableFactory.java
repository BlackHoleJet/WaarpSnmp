/**
   This file is part of GoldenGate Project (named also GoldenGate or GG).

   Copyright 2009, Frederic Bregier, and individual contributors by the @author
   tags. See the COPYRIGHT.txt in the distribution for a full listing of
   individual contributors.

   All GoldenGate Project is free software: you can redistribute it and/or 
   modify it under the terms of the GNU General Public License as published 
   by the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   GoldenGate is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with GoldenGate .  If not, see <http://www.gnu.org/licenses/>.
 */
package goldengate.snmp.test;

import org.snmp4j.smi.Counter32;
import org.snmp4j.smi.Counter64;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.IpAddress;
import org.snmp4j.smi.Null;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.Opaque;
import org.snmp4j.smi.SMIConstants;
import org.snmp4j.smi.TimeTicks;
import org.snmp4j.smi.Variable;

import goldengate.snmp.interf.GgInterfaceVariableFactory;

/**
 * @author Frederic Bregier
 *
 */
public class GgTestVariableFactory implements GgInterfaceVariableFactory {

    /* (non-Javadoc)
     * @see goldengate.snmp.GgVariableFactory#getVariable(OID, int, int, int)
     */
    @Override
    public Variable getVariable(OID oid, int type, int mibLevel, int entry) {
        Variable var;
        switch (type) {
            case SMIConstants.SYNTAX_INTEGER:
            //case SMIConstants.SYNTAX_INTEGER32:
                var = new Integer32();
                break;
            case SMIConstants.SYNTAX_OCTET_STRING:
            //case SMIConstants.SYNTAX_BITS:
                var = new OctetString();
                break;
            case SMIConstants.SYNTAX_NULL:
                var = new Null();
                break;
            case SMIConstants.SYNTAX_OBJECT_IDENTIFIER:
                var = new OID();
                break;
            case SMIConstants.SYNTAX_IPADDRESS:
                var = new IpAddress();
                break;
            case SMIConstants.SYNTAX_COUNTER32:
                var = new Counter32();
                break;
            case SMIConstants.SYNTAX_GAUGE32:
            //case SMIConstants.SYNTAX_UNSIGNED_INTEGER32:
                var = new ExampleImplGauge32(oid);
                break;
            case SMIConstants.SYNTAX_TIMETICKS:
                var = new TimeTicks();
                break;
            case SMIConstants.SYNTAX_OPAQUE:
                var = new Opaque();
                break;
            case SMIConstants.SYNTAX_COUNTER64:
                var = new Counter64();
                break;
            default:
                throw new IllegalArgumentException("Unmanaged Type: " +
                        type);
        }
        return var;
    }

}