/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */
         
// MESSAGE AHRS3 PACKING
package com.MAVLink.ardupilotmega;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Parser;
import com.MAVLink.ardupilotmega.CRC;
import java.nio.ByteBuffer;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
* Status of third AHRS filter if available. This is for ANU research group (Ali and Sean)
*/
public class msg_ahrs3_test{

public static final int MAVLINK_MSG_ID_AHRS3 = 182;
public static final int MAVLINK_MSG_LENGTH = 40;
private static final long serialVersionUID = MAVLINK_MSG_ID_AHRS3;

private Parser parser = new Parser();

public CRC generateCRC(byte[] packet){
    CRC crc = new CRC();
    for (int i = 1; i < packet.length - 2; i++) {
        crc.update_checksum(packet[i] & 0xFF);
    }
    crc.finish_checksum(MAVLINK_MSG_ID_AHRS3);
    return crc;
}

public byte[] generateTestPacket(){
    ByteBuffer payload = ByteBuffer.allocate(6 + MAVLINK_MSG_LENGTH + 2);
    payload.put((byte)MAVLinkPacket.MAVLINK_STX); //stx
    payload.put((byte)MAVLINK_MSG_LENGTH); //len
    payload.put((byte)0); //seq
    payload.put((byte)255); //sysid
    payload.put((byte)190); //comp id
    payload.put((byte)MAVLINK_MSG_ID_AHRS3); //msg id
    payload.putFloat((float)17.0); //roll
    payload.putFloat((float)45.0); //pitch
    payload.putFloat((float)73.0); //yaw
    payload.putFloat((float)101.0); //altitude
    payload.putInt((int)963498296); //lat
    payload.putInt((int)963498504); //lng
    payload.putFloat((float)185.0); //v1
    payload.putFloat((float)213.0); //v2
    payload.putFloat((float)241.0); //v3
    payload.putFloat((float)269.0); //v4
    
    CRC crc = generateCRC(payload.array());
    payload.put((byte)crc.getLSB());
    payload.put((byte)crc.getMSB());
    return payload.array();
}

@Test
public void test(){
    byte[] packet = generateTestPacket();
    for(int i = 0; i < packet.length - 1; i++){
        parser.mavlink_parse_char(packet[i] & 0xFF);
    }
    MAVLinkPacket m = parser.mavlink_parse_char(packet[packet.length - 1] & 0xFF);
    byte[] processedPacket = m.encodePacket();
    assertArrayEquals("msg_ahrs3", processedPacket, packet);
}
}
        