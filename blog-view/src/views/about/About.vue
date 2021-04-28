<template>
    <div>
        <!--header-->
		<div class="ui top attached segment m-padded-lr-big">
			<h2 class="m-text-500" style="text-align: center">About me</h2>
			<meting-js server="netease" type="song" :id="about.musicId" theme="#25CCF7" v-if="about.musicId!==''"></meting-js>
			<div class="typo content m-margin-top-large" v-viewer v-html="about.content"></div>
		</div>
		<!--评论-->
		<div class="ui bottom teal attached segment threaded comments">
			<CommentList :page="1" :blogId="null" v-if="about.commentEnabled==='true'"/>
			<h3 class="ui header" v-else>评论已关闭</h3>
		</div>
    </div>
</template>