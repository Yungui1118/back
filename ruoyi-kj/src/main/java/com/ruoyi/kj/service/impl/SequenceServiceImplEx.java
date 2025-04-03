package com.ruoyi.kj.service.impl;

import com.ruoyi.kj.mapper.SequenceMapperEx;
import com.ruoyi.kj.service.ISequenceServiceEx;
import com.ruoyi.kj.utils.KjConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zheng yang
 * @date 2022/2/21 0:40
 */
@Service
public class SequenceServiceImplEx implements ISequenceServiceEx {

    @Autowired
    private SequenceMapperEx sequenceMapperEx;

    /**
     * 创建一个唯一的序列号
     * */
    @Transactional
    @Override
    public String buildOnlyNumber(String type) {
        switch (type){
            case "0":
                type = KjConstants.SALE_NUMBER_SEQ;
                break;
            case "1":
                type = KjConstants.PURCHASE_NUMBER_SEQ;
                break;
            default:
                type = KjConstants.WEIGHT_NUMBER_SEQ;
        }
        String localDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        Long buildOnlyNumber=null;
        String seqPrefix="";
        synchronized (this){
            try{
                //编号+1
                sequenceMapperEx.updateBuildOnlyNumber(type);
                buildOnlyNumber= sequenceMapperEx.getBuildOnlyNumber(type);
                seqPrefix=sequenceMapperEx.getSeqPrefix(type);
            }catch(Exception e){
                // KjException.writeFail(logger, e);
            }
        }
        StringBuilder sb=new StringBuilder(buildOnlyNumber.toString());
        if(buildOnlyNumber<KjConstants.SEQ_TO_STRING_MIN_LENGTH){
            int len=KjConstants.SEQ_TO_STRING_MIN_LENGTH.toString().length()-sb.length();
            for(int i=0;i<len;i++){
                sb.insert(0,KjConstants.SEQ_TO_STRING_LESS_INSERT);
            }
        }
        sb.insert(0,seqPrefix+localDate);
        return sb.toString();
    }
}
