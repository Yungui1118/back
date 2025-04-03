package com.ruoyi.kj.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kj.mapper.CardMapper;
import com.ruoyi.kj.domain.Card;
import com.ruoyi.kj.service.ICardService;

/**
 * 卡号信息Service业务层处理
 *
 * @author weiliang
 * @date 2022-02-21
 */
@Service
public class CardServiceImpl implements ICardService
{
    @Autowired
    private CardMapper cardMapper;

    /**
     * 查询卡号信息
     *
     * @param cardId 卡号信息主键
     * @return 卡号信息
     */
    @Override
    public Card selectCardByCardId(Long cardId)
    {
        return cardMapper.selectCardByCardId(cardId);
    }

    /**
     * 查询卡号信息列表
     *
     * @param card 卡号信息
     * @return 卡号信息
     */
    @Override
    public List<Card> selectCardList(Card card)
    {
        return cardMapper.selectCardList(card);
    }

    /**
     * 新增卡号信息
     *
     * @param card 卡号信息
     * @return 结果
     */
    @Override
    public int insertCard(Card card)
    {
        card.setCreateTime(DateUtils.getNowDate());
        return cardMapper.insertCard(card);
    }

    /**
     * 修改卡号信息
     *
     * @param card 卡号信息
     * @return 结果
     */
    @Override
    public int updateCard(Card card)
    {
        card.setUpdateTime(DateUtils.getNowDate());
        return cardMapper.updateCard(card);
    }

    /**
     * 批量删除卡号信息
     *
     * @param cardIds 需要删除的卡号信息主键
     * @return 结果
     */
    @Override
    public int deleteCardByCardIds(Long[] cardIds)
    {
        return cardMapper.deleteCardByCardIds(cardIds);
    }

    /**
     * 删除卡号信息信息
     *
     * @param cardId 卡号信息主键
     * @return 结果
     */
    @Override
    public int deleteCardByCardId(Long cardId)
    {
        return cardMapper.deleteCardByCardId(cardId);
    }

    @Override
    public String selectCarNumberByCardNumber(String cardNumber) {
        return cardMapper.selectCarNumberByCardNumber(cardNumber);
    }
}
