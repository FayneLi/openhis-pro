package org.openhis.domain.test.liteflow.component;

import java.math.BigDecimal;

import org.openhis.domain.test.liteflow.entity.ClassEntity;
import org.springframework.stereotype.Component;

import com.yomahub.liteflow.core.NodeComponent;

/**
 * 优惠券抵扣计算组件
 */
@Component("couponCmp")
public class CouponCmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        ClassEntity context = this.getContextBean(ClassEntity.class);
        context.setClassName("oldCouponCmp");
        System.out.println("oldCouponCmp"+context.getClassName());
        context.setPackageName("oldCouponCmp");
        System.out.println("oldCouponCmp"+context.getPackageName());
        /**这里Mock下根据couponId取到的优惠卷面值为15元**/
        System.out.print("这是重写之前的方法");
    }

    @Override
    public boolean isAccess() {
        ClassEntity context = this.getContextBean(ClassEntity.class);
        if(context.getClassName() != null){
            return true;
        }else{
            return false;
        }
    }
}
