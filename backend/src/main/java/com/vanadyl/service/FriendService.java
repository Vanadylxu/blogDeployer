package com.vanadyl.service;

import com.vanadyl.entity.Friend;
import com.vanadyl.model.vo.FriendInfo;

import java.util.List;

public interface FriendService {
    List<Friend> getFriendList();

    List<com.vanadyl.model.vo.Friend> getFriendVOList();

    void updateFriendPublishedById(Long friendId, Boolean published);

    void saveFriend(Friend friend);

    void updateFriend(com.vanadyl.model.dto.Friend friend);

    void deleteFriend(Long id);

    void updateViewsByNickname(String nickname);

    FriendInfo getFriendInfo(boolean cache, boolean md);

    void updateFriendInfoContent(String content);

    void updateFriendInfoCommentEnabled(Boolean commentEnabled);
}
