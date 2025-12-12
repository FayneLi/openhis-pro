package org.openhis.domain.test.liteflow.component;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.openhis.domain.test.liteflow.entity.ClassEntity;
import org.springframework.stereotype.Component;

import com.yomahub.liteflow.core.NodeComponent;

/**
 * 会员折扣计算组件
 */
@Component("memberDiscountCmp")
public class MemberDiscountCmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        ClassEntity context = this.getContextBean(ClassEntity.class);
        context.setClassName("oldMemberDiscountCmp");
        System.out.println("oldMemberDiscountCmp"+context.getClassName());
        context.setPackageName("oldMemberDiscountCmp");
        System.out.println("oldMemberDiscountCmp"+context.getPackageName());
        /**这里Mock下根据couponId取到的优惠卷面值为15元**/
        System.out.print("这是重写之前的方法");

    }


}
