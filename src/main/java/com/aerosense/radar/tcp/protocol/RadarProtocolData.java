
package com.aerosense.radar.tcp.protocol;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： jia.w@aerosnese.com
 * @date： 2021/8/3 14:30
 * @version: 1.0
 */
@SuperBuilder
@NoArgsConstructor
public class RadarProtocolData implements Serializable {
    /** For serialization  */
    private static final long serialVersionUID = 1;
    /**protocol data fixed length：function：1， radarId：12，radarVersion：8*/
    public static final int DATA_FIX_LEN = 15;

    /**interface function*/
    private FunctionEnum    function;
    /**radar id*/
    private String          radarId;
    /**radar version*/
    private String          radarVersion;
    /**radar data*/
    private byte[]          data = new byte[4];

    public FunctionEnum getFunction() {
        return function;
    }

    public void setFunction(FunctionEnum function) {
        this.function = function;
    }

    public String getRadarId() {
        return radarId;
    }

    public void setRadarId(String radarId) {
        this.radarId = radarId;
    }

    public String getRadarVersion() {
        return radarVersion;
    }

    public void setRadarVersion(String radarVersion) {
        this.radarVersion = radarVersion;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
    /**
     * 创建一下新的空实例
     * @return
     */
    public static final RadarProtocolData newEmptyInstance(){
        return new RadarProtocolData();
    }
    /**
     * fill function
     * @param id
     * @param function
     * @param data
     * @return
     */
    public RadarProtocolData fillFunctionData(String id, FunctionEnum function, byte[] data){
        this.setRadarId(id);
        this.setFunction(function);
        this.setData(data);
        return this;
    }

    /**
     * create a new instance of the specified function
     * @return
     */
    public static final RadarProtocolData newFunctionInstance(FunctionEnum function, byte[] data){
        RadarProtocolData radarProtocolData = RadarProtocolData.newEmptyInstance();
        radarProtocolData.setFunction(function);
        radarProtocolData.setData(data);
        return radarProtocolData;
    }

    @Override
    public String toString() {
        return "RadarProtocolData{" +
                "function=" + function +
                ", radarId='" + radarId + '\'' +
                ", radarVersion='" + radarVersion + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
//
//    /**
//     * convert to the data format byte array transmitted by the previous HTTP protocol
//     * @return
//     */
//    public byte[] toBytes(){
//        StringBuilder fixStr = new StringBuilder();
//        fixStr.append(function.toString()).append(",");
//        fixStr.append(radarId);
//        if(function!=FunctionEnum.HeatMap){
//            fixStr.append(",").append(radarVersion);
//        }
//        int heatMapLen =  getData()!=null ? getData().length : 0;
//        if(heatMapLen>0){
//            fixStr.append(",");
//        }
//        byte[] fixBytes = fixStr.toString().getBytes(StandardCharsets.UTF_8);
//        byte[] data = new byte[fixBytes.length + heatMapLen];
//        System.arraycopy(fixBytes, 0, data, 0, fixBytes.length);
//        if(heatMapLen>0){
//            System.arraycopy(getData(),0, data, fixBytes.length, heatMapLen);
//        }
//        return data;
//    }
}
