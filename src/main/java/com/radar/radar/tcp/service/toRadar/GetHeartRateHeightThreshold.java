package com.radar.radar.tcp.service.toRadar;

import io.netty.buffer.ByteBuf;
import org.springframework.stereotype.Service;

import com.radar.radar.tcp.hander.base.AbstractToRadarProtocolDataHandler;
import com.radar.radar.tcp.protocol.FunctionEnum;

/**
 * @author ：ywb
 * @date ：Created in 2022/1/8 17:55
 * @modified By：
 */
@Service
public class GetHeartRateHeightThreshold extends AbstractToRadarProtocolDataHandler {

    public Integer process(String radarId) throws Exception {
        ByteBuf byteBuf = super.processDo(radarId, FunctionEnum.getHeartRateHeightThreshold);
        int readInt = byteBuf.readInt();
        byteBuf.release();
        return readInt;
    }

}
