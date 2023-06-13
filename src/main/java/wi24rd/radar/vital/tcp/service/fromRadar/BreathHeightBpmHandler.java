package wi24rd.radar.vital.tcp.service.fromRadar;

import com.google.common.collect.Sets;

import wi24rd.radar.vital.tcp.handler.base.AbstractFromRadarProtocolDataHandler;
import wi24rd.radar.vital.tcp.handler.callback.RadarHandlerCallBack;
import wi24rd.radar.vital.tcp.protocol.FunctionEnum;
import wi24rd.radar.vital.tcp.protocol.RadarProtocolData;

import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author ：ywb
 * @date ：Created in 2022/1/7 10:35
 * @modified By：
 */
@Service
public class BreathHeightBpmHandler extends AbstractFromRadarProtocolDataHandler {

    public BreathHeightBpmHandler(RadarHandlerCallBack handlerCallBack) {
        super(handlerCallBack);
    }

    @Override
    public Object process(RadarProtocolData protocolData) {
        protocolData.setFunction(FunctionEnum.breathHeightBpmAlert);
        handlerCallBack.callBack(protocolData);
        return null;
    }

    @Override
    public Set<FunctionEnum> interests() {
        return Sets.newHashSet(FunctionEnum.breathHeightBpmAlert);
    }
}