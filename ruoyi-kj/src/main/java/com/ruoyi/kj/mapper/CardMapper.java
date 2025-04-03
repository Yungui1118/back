package com.ruoyi.kj.mapper;

import com.ruoyi.kj.domain.Card;

import java.util.List;

/**
 * 卡号信息Mapper接口
 *
 * @author weiliang
 * @date 2022-02-21
 */
public interface CardMapper
{
    /**
     * 查询卡号信息
     *
     * @param cardId 卡号信息主键
     * @return 卡号信息
     */
    public Card selectCardByCardId(Long cardId);

    /**
     * 查询卡号信息列表
     *
     * @param card 卡号信息
     * @return 卡号信息集合
     */
    public List<Card> selectCardList(Card card);

    public Card selectCardByCarNumber(String carNumber);

    /**
     * 新增卡号信息
     *
     * @param card 卡号信息
     * @return 结果
     */
    public int insertCard(Card card);

    /**
     * 修改卡号信息
     *
     * @param card 卡号信息
     * @return 结果
     */
    public int updateCard(Card card);

    /**
     * 删除卡号信息
     *
     * @param cardId 卡号信息主键
     * @return 结果
     */
    public int deleteCardByCardId(Long cardId);

    /**
     * 批量删除卡号信息
     *
     * @param cardIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCardByCardIds(Long[] cardIds);

    public String selectCarNumberByCardNumber(String cardNumber);
}
