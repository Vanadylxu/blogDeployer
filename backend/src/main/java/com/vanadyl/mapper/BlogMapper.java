package com.vanadyl.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.vanadyl.entity.Blog;
import com.vanadyl.model.dto.BlogView;
import com.vanadyl.model.dto.BlogVisibility;
import com.vanadyl.model.vo.ArchiveBlog;
import com.vanadyl.model.vo.BlogDetail;
import com.vanadyl.model.vo.BlogInfo;
import com.vanadyl.model.vo.CategoryBlogCount;
import com.vanadyl.model.vo.NewBlog;
import com.vanadyl.model.vo.RandomBlog;
import com.vanadyl.model.vo.SearchBlog;

import java.util.List;

/**
 * @Description: 博客文章持久层接口
 * @Author: Naccl
 * @Date: 2020-07-26
 */
@Mapper
@Repository
public interface BlogMapper {
    List<Blog> getListByTitleAndCategoryId(String title, Integer categoryId);

    List<SearchBlog> getSearchBlogListByQueryAndIsPublished(String query);

    List<Blog> getIdAndTitleList();

    List<NewBlog> getNewBlogListByIsPublished();

    List<BlogInfo> getBlogInfoListByIsPublished();

    List<BlogInfo> getBlogInfoListByCategoryNameAndIsPublished(String categoryName);

    List<BlogInfo> getBlogInfoListByTagNameAndIsPublished(String tagName);

    List<String> getGroupYearMonthByIsPublished();

    List<ArchiveBlog> getArchiveBlogListByYearMonthAndIsPublished(String yearMonth);

    List<RandomBlog> getRandomBlogListByLimitNumAndIsPublishedAndIsRecommend(Integer limitNum);

    List<BlogView> getBlogViewsList();

    int deleteBlogById(Long id);

    int deleteBlogTagByBlogId(Long blogId);

    int saveBlog(com.vanadyl.model.dto.Blog blog);

    int saveBlogTag(Long blogId, Long tagId);

    int updateBlogRecommendById(Long blogId, Boolean recommend);

    int updateBlogVisibilityById(Long blogId, BlogVisibility bv);

    int updateBlogTopById(Long blogId, Boolean top);

    int updateViews(Long blogId, Integer views);

    Blog getBlogById(Long id);

    String getTitleByBlogId(Long id);

    BlogDetail getBlogByIdAndIsPublished(Long id);

    String getBlogPassword(Long blogId);

    int updateBlog(com.vanadyl.model.dto.Blog blog);

    int countBlog();

    int countBlogByIsPublished();

    int countBlogByCategoryId(Long categoryId);

    int countBlogByTagId(Long tagId);

    Boolean getCommentEnabledByBlogId(Long blogId);

    Boolean getPublishedByBlogId(Long blogId);

    List<CategoryBlogCount> getCategoryBlogCountList();
}
