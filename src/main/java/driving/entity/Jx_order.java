package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Jx_order {
    //   流水号
    @Id
    private Integer oId;
    //    付款金额
    @Column
    private String total_amount;
    //    支付宝交易号
    @Column
    private String trade_no;
    //    支付备注交易号
    @Column
    private String checkrRemarks;
    //    所属客户编号
    @Column
    private Integer uid;
}
