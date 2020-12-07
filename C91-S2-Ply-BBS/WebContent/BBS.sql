/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : c0-s2-ply-demo

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2020-06-19 11:20:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_board
-- ----------------------------
DROP TABLE IF EXISTS `tbl_board`;
CREATE TABLE `tbl_board` (
  `id` int(11) NOT NULL auto_increment,
  `boardname` varchar(100) default NULL,
  `parentid` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_board
-- ----------------------------
INSERT INTO `tbl_board` VALUES ('1', '.net版块', '0');
INSERT INTO `tbl_board` VALUES ('2', 'java版块', '0');
INSERT INTO `tbl_board` VALUES ('3', '数据库版块', '0');
INSERT INTO `tbl_board` VALUES ('4', '软件工程版块', '0');
INSERT INTO `tbl_board` VALUES ('5', 'ado.net', '1');
INSERT INTO `tbl_board` VALUES ('6', 'asp.net', '1');
INSERT INTO `tbl_board` VALUES ('7', 'vb.net', '1');
INSERT INTO `tbl_board` VALUES ('8', 'jsp', '2');
INSERT INTO `tbl_board` VALUES ('9', 'struts', '2');
INSERT INTO `tbl_board` VALUES ('10', 'hibernate', '2');
INSERT INTO `tbl_board` VALUES ('11', 'sql', '3');
INSERT INTO `tbl_board` VALUES ('12', 'oracle', '3');
INSERT INTO `tbl_board` VALUES ('13', 'mysql', '3');

-- ----------------------------
-- Table structure for tbl_reply
-- ----------------------------
DROP TABLE IF EXISTS `tbl_reply`;
CREATE TABLE `tbl_reply` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(50) default NULL,
  `content` varchar(1000) default NULL,
  `publishtime` timestamp NULL default CURRENT_TIMESTAMP,
  `modifytime` timestamp NULL default NULL,
  `uid` int(11) default NULL,
  `topicid` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_reply_uid` (`uid`),
  KEY `FK_reply_topicid` (`topicid`),
  CONSTRAINT `FK_reply_topicid` FOREIGN KEY (`topicid`) REFERENCES `tbl_topic` (`id`),
  CONSTRAINT `FK_reply_uid` FOREIGN KEY (`uid`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_reply
-- ----------------------------
INSERT INTO `tbl_reply` VALUES ('1', '2222', '<p>222233333</p>\r\n', '2018-06-25 15:57:40', '2018-06-25 15:57:40', '1', '1');
INSERT INTO `tbl_reply` VALUES ('2', 'qqqq', '<p style=\"text-align:center\"><strong>qqqq</strong></p>\r\n\r\n<p>这是我<s>的饿作为</s></p>\r\n', '2018-06-25 16:42:54', '2018-06-25 16:42:54', '1', '1');
INSERT INTO `tbl_reply` VALUES ('3', '12121', '21212', null, null, '3', '21');
INSERT INTO `tbl_reply` VALUES ('4', '324234', '34234', null, null, '3', '1');
INSERT INTO `tbl_reply` VALUES ('5', '23232', '2323', null, null, '3', '1');
INSERT INTO `tbl_reply` VALUES ('6', '123123', '123123', '2020-06-17 10:36:48', null, '3', '1');
INSERT INTO `tbl_reply` VALUES ('7', '111', '<p>1111</p>', '2020-06-17 10:52:07', null, '3', '1');
INSERT INTO `tbl_reply` VALUES ('8', '1212', '<h1><a href=\"https://www.cnblogs.com/flyfish2012/\">ザ紫鱼(Tiler)ザ</a></h1>\n\n<p>好学若饥,谦卑若愚！痛而不言，笑而不语！</p>\n\n<h2><a href=\"https://www.cnblogs.com/flyfish2012/p/3727207.html\">Ckeditor的JS的加载和取值和赋值方法</a></h2>\n\n<p>Ckeditor 就是原来的Fckeditor.</p>\n\n<p>JS加载：</p>\n\n<pre>\n    $(function() {\n        CKEDITOR.replace(&#39;FContent&#39;); //FContent：这个对应文本域\n    });</pre>\n\n<p>JS取值：</p>\n\n<pre>\nvar content = CKEDITOR.instances.FContent.getData();\n                    if (content == &quot;&quot; || comtent == null) {\n                        alert(&quot;邮件正文不可为空!&quot;);\n                    }</pre>\n\n<p>JS赋值：</p>', '2020-06-17 10:52:32', null, '3', '1');

-- ----------------------------
-- Table structure for tbl_topic
-- ----------------------------
DROP TABLE IF EXISTS `tbl_topic`;
CREATE TABLE `tbl_topic` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(50) default NULL,
  `content` varchar(4000) default NULL,
  `publishtime` timestamp NULL default CURRENT_TIMESTAMP,
  `modifytime` timestamp NULL default NULL,
  `uid` int(11) default NULL,
  `boardid` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_topic_uid` (`uid`),
  KEY `FK_topic_boardid` (`boardid`),
  CONSTRAINT `FK_topic_boardid` FOREIGN KEY (`boardid`) REFERENCES `tbl_board` (`id`),
  CONSTRAINT `FK_topic_uid` FOREIGN KEY (`uid`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_topic
-- ----------------------------
INSERT INTO `tbl_topic` VALUES ('1', '1111', '<p>111111222222</p>\r\n', '2018-06-25 15:56:49', '2018-06-25 15:56:49', '1', '5');
INSERT INTO `tbl_topic` VALUES ('2', '11111', '11111', null, null, '1', '5');
INSERT INTO `tbl_topic` VALUES ('3', '累了', '再试一次', '2018-06-25 21:10:44', '2018-06-25 21:10:44', '1', '8');
INSERT INTO `tbl_topic` VALUES ('4', 'aaa', 'aaaa', null, null, '1', '8');
INSERT INTO `tbl_topic` VALUES ('5', '123', '1234', null, null, '1', '5');
INSERT INTO `tbl_topic` VALUES ('6', '123', '1234', null, null, '1', '5');
INSERT INTO `tbl_topic` VALUES ('7', '123', '1234', null, null, '1', '5');
INSERT INTO `tbl_topic` VALUES ('8', '123', '1234', null, null, '1', '5');
INSERT INTO `tbl_topic` VALUES ('9', '123', '1234', null, null, '1', '5');
INSERT INTO `tbl_topic` VALUES ('10', 'dfdfd', 'fdfdfd', null, null, '1', '5');
INSERT INTO `tbl_topic` VALUES ('11', 'avasdfa', 'asdfasdfa', null, null, '1', '5');
INSERT INTO `tbl_topic` VALUES ('12', 'vvvvv', 'asdfasf', '2018-07-02 10:31:57', '2018-07-02 10:31:57', '1', '5');
INSERT INTO `tbl_topic` VALUES ('13', 'ddddd', '<p><strong>123asd</strong></p>\r\n', '2018-07-03 00:29:29', '2018-07-03 00:29:29', '1', '5');
INSERT INTO `tbl_topic` VALUES ('14', 'dfdfdf', '<p>dfdfdfd<strong>dfdfdfdf<u>dfdfdfdf<sup>dfdfdfdf</sup></u></strong>dfdfdfdf</p>\r\n', '2018-07-05 23:20:28', '2018-07-05 23:20:28', '1', '5');
INSERT INTO `tbl_topic` VALUES ('15', '的点点滴滴', '<div class=\"privacy-lead-in\">\r\n<div class=\"content-girdle\">\r\n<h2>在 Mozilla，我们认为隐私是健康互联网的基石。</h2>\r\n\r\n<div class=\"optional-lead-in\">\r\n<p>这就是我们创建 Firefox 以及所有产品的初衷，目的是让您能够更好地控制您在网上共享的信息以及与我们共享的信息。我们力求只收集为大家改进 Firefox 而需要的信息。</p>\r\n</div>\r\n\r\n<p>在本&ldquo;隐私声明&rdquo;中，我们会说明 Firefox 共享的数据，并帮助您设置，以减少共享内容。我们还遵守在 Mozilla <a href=\"https://www.mozilla.org/privacy/\">隐私政策</a>中规定的，有关如何获取、处理并共享我们从 Firefox 收集的信息的惯例。</p>\r\n\r\n<h2>默认情况下，Firefox 会共享数据，以：</h2>\r\n\r\n<h3>为各地的用户改进性能和稳定性</h3>\r\n\r\n<div>\r\n<ul>\r\n	<li>\r\n	<p><strong>交互数据</strong>：Firefox 会发送以下相关数据给我们：您与 Firefox 的交互（例如，打开的选项卡和窗口的数量；访问网页的数量；已安装 Firefox 附加组件的数量和类型；以及会话时长），以及由 Mozilla 或我们的合作伙伴所提供的 Firefox 功能（例如与 Firefox 搜索功能的交互以及搜索合作伙伴的推荐）。</p>\r\n	</li>\r\n	<li>\r\n	<p><strong>技术数据</strong>：Firefox 会发送以下相关信息给我们：您 Firefox 的版本和语言；设备操作系统和硬件配置；内存、有关崩溃和错误的基本信息；诸如更新、安全浏览和激活等自动化流程的结果。当 Firefox 向我们发送数据时，会临时收集您的 IP 地址作为我们服务器日志的一部分。</p>\r\n	</li>\r\n</ul>\r\n\r\n<p>阅读针对<a href=\"https://firefox-source-docs.mozilla.org/toolkit/components/telemetry/telemetry/index.html\">桌面</a>、<a href=\"https://firefox-source-docs.mozilla.org/mobile/android/fennec/index.html\">Android</a> 或 <a href=\"https://github.com/mozilla-mobile/firefox-ios/wiki/Telemetry\">iOS</a> 的遥测技术文档，或者了解如何<a href=\"https://support.mozilla.org/kb/send-performance-data-improve-firefox\">选择退出</a>该数据收集功能。</p>\r\n\r\n<div class=\"data-choices\">\r\n<p>选择如何共享您使用 Firefox 的数据。</p>\r\n</div>\r\n</div>\r\n</div>\r\n</div>\r\n', '2018-07-06 16:54:09', '2018-07-06 16:54:09', null, '5');
INSERT INTO `tbl_topic` VALUES ('16', '测试帖子', '测试帖子测试帖子测试帖子测试帖子', '2020-06-04 10:19:19', null, null, '5');
INSERT INTO `tbl_topic` VALUES ('17', '标 题标 题', '标 题标 题标 题标 题标 题', '2020-06-04 10:23:32', null, null, '5');
INSERT INTO `tbl_topic` VALUES ('18', '你好', '你好你好你好', '2020-06-04 11:20:08', null, '2', '5');
INSERT INTO `tbl_topic` VALUES ('19', '111', '111', '2020-06-04 14:58:21', null, '2', '6');
INSERT INTO `tbl_topic` VALUES ('20', '123123', '123123', null, null, '3', '6');
INSERT INTO `tbl_topic` VALUES ('21', '222', '123123', '2020-06-17 10:19:02', null, '3', '5');
INSERT INTO `tbl_topic` VALUES ('22', 's\'d\'f', '<p>sdfaf</p>', '2020-06-17 11:42:04', null, '3', '5');

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL auto_increment,
  `uname` varchar(20) default NULL,
  `upass` varchar(100) default NULL,
  `head` varchar(100) default NULL,
  `regtime` datetime default NULL,
  `gender` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', 'yc', '123', '2.gif', '2018-06-25 15:40:46', '0');
INSERT INTO `tbl_user` VALUES ('2', 'ly', '123', '1.gif', '2020-06-03 20:12:37', '1');
INSERT INTO `tbl_user` VALUES ('3', '111', '111', '1.gif', null, '1');
INSERT INTO `tbl_user` VALUES ('6', '222', '222', '1.gif', null, '1');
INSERT INTO `tbl_user` VALUES ('7', '333', '111', '1.gif', null, '1');
