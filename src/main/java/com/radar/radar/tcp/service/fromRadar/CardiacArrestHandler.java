package com.radar.radar.tcp.service.fromRadar;

import com.google.common.collect.Sets;
import com.radar.radar.tcp.hander.base.AbstractFromRadarProtocolDataHandler;
import com.radar.radar.tcp.hander.callback.RadarHandlerCallBack;
import com.radar.radar.tcp.protocol.FunctionEnum;
import com.radar.radar.tcp.protocol.RadarProtocolData;

import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author ：ywb
 * @date ：Created in 2022/1/7 10:35
 * @modified By：
 * <p>
 */
@Service
public class CardiacArrestHandler extends AbstractFromRadarProtocolDataHandler {
    public CardiacArrestHandler(RadarHandlerCallBack handlerCallBack) {
        super(handlerCallBack);
    }

    @Override
    public Object process(RadarProtocolData protocolData) {
        protocolData.setFunction(FunctionEnum.cardiacArrest);
        handlerCallBack.callBack(protocolData);
        return null;
    }

    @Override
    public Set<FunctionEnum> interests() {
        return Sets.newHashSet(FunctionEnum.cardiacArrest);
    }
}
