package com.aerosense.radar.tcp.protocol;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * radar firmware upgrade dto
 * @author jia.wu
 */

public class RadarUpgradeFirmwareDto implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * radar id
     */
    private List<String> radarIds;
    /**
     * firmware binary data
     */
    private byte[] firmwareData;

    public RadarUpgradeFirmwareDto(){}

    public RadarUpgradeFirmwareDto(List<String> radarIds, byte[] firmwareData) {
        this.radarIds = radarIds;
        this.firmwareData = firmwareData;
    }

    public List<String> getRadarIds() {
        return radarIds;
    }

    public void setRadarIds(List<String> radarIds) {
        this.radarIds = radarIds;
    }

    public byte[] getFirmwareData() {
        return firmwareData;
    }

    public void setFirmwareData(byte[] firmwareData) {
        this.firmwareData = firmwareData;
    }

    @Override
    public String toString() {
        return "RadarUpgradeFirmwareDto{" +
                "radarIds='" + radarIds + '\'' +
                ", firmwareData=" + Arrays.toString(firmwareData) +
                '}';
    }
}
