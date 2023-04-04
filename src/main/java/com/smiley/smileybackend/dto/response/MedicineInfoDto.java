package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.Medicine;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;


@ToString
@Getter
@NoArgsConstructor
public class MedicineInfoDto {

    private Integer id;

    /**
     * 업체명
     * */
    private String entpName;

    /**
     * 제품명
     * */
    private String itemName;

    /**
     * 품목기준코드
     * */
    private String itemSeq;

    /**
     * 문항1(효능)
     * */
    private String efcyQesitm;

    /**
     * 문항2(사용법)
     * */
    private String useMethodQesitm;

    /**
     * 문항3(주의사항경고)
     * */
    private String atpnWarnQesitm;

    /**
     * 문항4(주의사항)
     * */String atpnQesitm;


    /**
     * 문항5(상호작용)
     * */
    private String intrcQesitm;

    /**
     * 문항6(부작용)
     * */
    private String seQesitm;

    /**
     * 문항7(보관법)
     * */
    private String depositMethodQesitm;

    /**
     * 공개일자
     * */
    private String openDe;

    /**
     * 수정일자
     * */
    private String updateDe;

    /**
     * 낱알이미지
     * */
    private String itemImage;

    public MedicineInfoDto(Medicine saved) {
        this.id = saved.getId();
        this.entpName = saved.getEntpName();
        this.itemName =saved.getItemName();
        this.itemSeq = saved.getItemSeq();
        this.efcyQesitm = saved.getEfcyQesitm();
        this.useMethodQesitm = saved.getUseMethodQesitm();
        this.atpnWarnQesitm = saved.getAtpnWarnQesitm();
        this.atpnQesitm = saved.getAtpnQesitm();
        this.intrcQesitm = saved.getIntrcQesitm();
        this.seQesitm = saved.getSeQesitm();
        this.depositMethodQesitm = saved.getDepositMethodQesitm();
        this.openDe = saved.getOpenDe();
        this.updateDe = saved.getUpdateDe();
        this.itemImage = saved.getItemImage();
    }

    public MedicineInfoDto(Integer id, String entpName, String itemName, String itemSeq, String efcyQesitm, String useMethodQesitm, String atpnWarnQesitm, String atpnQesitm, String intrcQesitm, String seQesitm, String depositMethodQesitm, String openDe, String updateDe, String itemImage) {
        this.id = id;
        this.entpName = entpName;
        this.itemName = itemName;
        this.itemSeq = itemSeq;
        this.efcyQesitm = efcyQesitm;
        this.useMethodQesitm = useMethodQesitm;
        this.atpnWarnQesitm = atpnWarnQesitm;
        this.atpnQesitm = atpnQesitm;
        this.intrcQesitm = intrcQesitm;
        this.seQesitm = seQesitm;
        this.depositMethodQesitm = depositMethodQesitm;
        this.openDe = openDe;
        this.updateDe = updateDe;
        this.itemImage = itemImage;
    }
}
