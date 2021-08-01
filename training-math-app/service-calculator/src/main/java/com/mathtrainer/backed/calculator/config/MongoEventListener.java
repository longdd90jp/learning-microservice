package com.mathtrainer.backed.calculator.config;

import com.mathtrainer.backed.calculator.domain.BaseDocument;
import com.mathtrainer.backed.calculator.utils.UserUtil;
import com.mathtrainer.backed.common.domain.CommonDocument;
import com.mathtrainer.backed.common.dto.UserInfoDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MongoEventListener extends AbstractMongoEventListener<Object> {

    @Autowired
    private UserUtil userUtil;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        Object source = event.getSource();
        // set tracking data
        setTrackingInfo(source);
    }

    private void setTrackingInfo(Object source) {
        Date dateNow = new Date();
        // set tracking data
        if(source instanceof BaseDocument) {
            UserInfoDto userInfo = userUtil.getLoginUserInfo();
            BaseDocument document = (BaseDocument) source;

            if(StringUtils.isEmpty(document.getId())) {
                // insert
                document.setCreatedDate(dateNow);
                document.setCreatedBy(userInfo.getUserId());
            } else {
                // update
                document.setUpdatedDate(dateNow);
                document.setUpdatedBy(userInfo.getUserId());
            }
        }
    }
}
