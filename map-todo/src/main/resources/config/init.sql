/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.122
 Source Server Type    : MySQL
 Source Server Version : 50738
 Source Host           : 192.168.1.122:3306
 Source Schema         : map

 Target Server Type    : MySQL
 Target Server Version : 50738
 File Encoding         : 65001

 Date: 20/10/2023 14:53:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `parent_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `active_menu` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `component` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `is_affix` bit(1) NULL DEFAULT NULL,
  `is_full` bit(1) NULL DEFAULT NULL,
  `is_hide` bit(1) NULL DEFAULT NULL,
  `is_keep_alive` bit(1) NULL DEFAULT NULL,
  `is_link` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `path` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `redirect` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`menu_id`, `parent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10020103 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (0, 1, NULL, '/home/index', 'HomeFilled', b'1', b'0', b'0', b'1', NULL, 'home', '/home/index', NULL, '首页');
INSERT INTO `sys_menu` VALUES (0, 2, NULL, NULL, 'MessageBox', b'0', b'0', b'0', b'1', NULL, 'proTable', '/proTable', '/proTable/useProTable', '超级表格');
INSERT INTO `sys_menu` VALUES (0, 3, NULL, '/dataScreen/index', 'Histogram', b'0', b'1', b'0', b'1', NULL, 'dataScreen', '/dataScreen', NULL, '数据大屏');
INSERT INTO `sys_menu` VALUES (0, 4, NULL, NULL, 'Lock', b'0', b'0', b'0', b'1', NULL, 'auth', '/auth', '/auth/menu', '权限管理');
INSERT INTO `sys_menu` VALUES (0, 5, NULL, NULL, 'Briefcase', b'0', b'0', b'0', b'1', NULL, 'assembly', '/assembly', '/assembly/guide', '常用组件');
INSERT INTO `sys_menu` VALUES (0, 6, NULL, NULL, 'Odometer', b'0', b'0', b'0', b'1', NULL, 'dashboard', '/dashboard', '/dashboard/dataVisualize', 'Dashboard');
INSERT INTO `sys_menu` VALUES (0, 7, NULL, NULL, 'Tickets', b'0', b'0', b'0', b'1', NULL, 'form', '/form', '/form/proForm', '表单 Form');
INSERT INTO `sys_menu` VALUES (0, 8, NULL, NULL, 'TrendCharts', b'0', b'0', b'0', b'1', NULL, 'echarts', '/echarts', '/echarts/waterChart', 'ECharts');
INSERT INTO `sys_menu` VALUES (0, 9, NULL, NULL, 'Stamp', b'0', b'0', b'0', b'1', NULL, 'directives', '/directives', '/directives/copyDirect', '自定义指令');
INSERT INTO `sys_menu` VALUES (0, 10, NULL, NULL, 'List', b'0', b'0', b'0', b'1', NULL, 'menu', '/menu', '/menu/menu1', '菜单嵌套');
INSERT INTO `sys_menu` VALUES (0, 11, NULL, '', 'Tools', b'0', b'0', b'0', b'1', NULL, 'system', '/system', '/system/accountManage', '系统管理');
INSERT INTO `sys_menu` VALUES (0, 12, NULL, NULL, 'Paperclip', b'0', b'0', b'0', b'1', NULL, 'link', '/link', '/link/bing', '外部链接');
INSERT INTO `sys_menu` VALUES (0, 13, NULL, '/about/index', 'InfoFilled', b'0', b'0', b'0', b'1', NULL, 'about', '/about/index', NULL, '关于项目');
INSERT INTO `sys_menu` VALUES (2, 201, NULL, '/proTable/useProTable/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'useProTable', '/proTable/useProTable', NULL, '使用 ProTable');
INSERT INTO `sys_menu` VALUES (2, 202, NULL, '/proTable/useTreeFilter/index', 'Menu', b'0', b'0', b'1', b'1', NULL, 'useTreeFilter', '/proTable/useTreeFilter', NULL, '使用 TreeFilter');
INSERT INTO `sys_menu` VALUES (2, 203, '/proTable/useTreeFilter', '/proTable/useTreeFilter/detail', 'Menu', b'0', b'0', b'1', b'1', NULL, 'useTreeFilterDetail', '/proTable/useTreeFilter/detail/:id', NULL, 'TreeFilter 详情');
INSERT INTO `sys_menu` VALUES (2, 204, NULL, '/proTable/useSelectFilter/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'useSelectFilter', '/proTable/useSelectFilter', NULL, '使用 SelectFilter');
INSERT INTO `sys_menu` VALUES (2, 205, NULL, '/proTable/treeProTable/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'treeProTable', '/proTable/treeProTable', NULL, '树形 ProTable');
INSERT INTO `sys_menu` VALUES (2, 206, NULL, '/proTable/complexProTable/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'complexProTable', '/proTable/complexProTable', NULL, '复杂 ProTable');
INSERT INTO `sys_menu` VALUES (2, 207, 'https://juejin.cn/post/7166068828202336263/#heading-14', '/proTable/document/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'proTableDocument', '/proTable/document', NULL, 'ProTable 文档');
INSERT INTO `sys_menu` VALUES (4, 401, NULL, '/auth/menu/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'authMenu', '/auth/menu', NULL, '菜单权限');
INSERT INTO `sys_menu` VALUES (4, 402, NULL, '/auth/button/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'authButton', '/auth/button', NULL, '按钮权限');
INSERT INTO `sys_menu` VALUES (5, 501, NULL, '/assembly/guide/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'guide', '/assembly/guide', NULL, '引导页');
INSERT INTO `sys_menu` VALUES (5, 502, NULL, '/assembly/tabs/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'tabs', '/assembly/tabs', NULL, '标签页操作');
INSERT INTO `sys_menu` VALUES (5, 503, NULL, '/assembly/selectIcon/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'selectIcon', '/assembly/selectIcon', NULL, '图标选择器');
INSERT INTO `sys_menu` VALUES (5, 504, NULL, '/assembly/selectFilter/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'selectFilter', '/assembly/selectFilter', NULL, '分类筛选器');
INSERT INTO `sys_menu` VALUES (5, 505, NULL, '/assembly/treeFilter/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'treeFilter', '/assembly/treeFilter', NULL, '树形筛选器');
INSERT INTO `sys_menu` VALUES (5, 506, NULL, '/assembly/svgIcon/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'svgIcon', '/assembly/svgIcon', NULL, 'SVG 图标');
INSERT INTO `sys_menu` VALUES (5, 507, NULL, '/assembly/uploadFile/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'uploadFile', '/assembly/uploadFile', NULL, '文件上传');
INSERT INTO `sys_menu` VALUES (5, 508, NULL, '/assembly/batchImport/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'batchImport', '/assembly/batchImport', '', '批量添加数据');
INSERT INTO `sys_menu` VALUES (5, 509, NULL, '/assembly/wangEditor/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'wangEditor', '/assembly/wangEditor', NULL, '富文本编辑器');
INSERT INTO `sys_menu` VALUES (6, 601, NULL, '/dashboard/dataVisualize/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'dataVisualize', '/dashboard/dataVisualize', NULL, '数据可视化');
INSERT INTO `sys_menu` VALUES (7, 701, NULL, '/form/proForm/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'proForm', '/form/proForm', NULL, '超级 Form');
INSERT INTO `sys_menu` VALUES (7, 702, NULL, '/form/basicForm/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'basicForm', '/form/basicForm', NULL, '基础 Form');
INSERT INTO `sys_menu` VALUES (7, 703, NULL, '/form/validateForm/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'validateForm', '/form/validateForm', NULL, '校验 Form');
INSERT INTO `sys_menu` VALUES (7, 704, NULL, '/form/dynamicForm/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'dynamicForm', '/form/dynamicForm', NULL, '动态 Form');
INSERT INTO `sys_menu` VALUES (8, 801, NULL, '/echarts/waterChart/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'waterChart', '/echarts/waterChart', NULL, '水型图');
INSERT INTO `sys_menu` VALUES (8, 802, NULL, '/echarts/columnChart/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'columnChart', '/echarts/columnChart', NULL, '柱状图');
INSERT INTO `sys_menu` VALUES (8, 803, NULL, '/echarts/lineChart/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'lineChart', '/echarts/lineChart', NULL, '折线图');
INSERT INTO `sys_menu` VALUES (8, 804, NULL, '/echarts/pieChart/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'pieChart', '/echarts/pieChart', NULL, '饼图');
INSERT INTO `sys_menu` VALUES (8, 805, NULL, '/echarts/radarChart/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'radarChart', '/echarts/radarChart', NULL, '雷达图');
INSERT INTO `sys_menu` VALUES (8, 806, NULL, '/echarts/nestedChart/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'nestedChart', '/echarts/nestedChart', NULL, '嵌套环形图');
INSERT INTO `sys_menu` VALUES (9, 901, NULL, '/directives/copyDirect/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'copyDirect', '/directives/copyDirect', NULL, '复制指令');
INSERT INTO `sys_menu` VALUES (9, 902, NULL, '/directives/watermarkDirect/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'watermarkDirect', '/directives/watermarkDirect', NULL, '水印指令');
INSERT INTO `sys_menu` VALUES (9, 903, NULL, '/directives/dragDirect/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'dragDirect', '/directives/dragDirect', NULL, '拖拽指令');
INSERT INTO `sys_menu` VALUES (9, 904, NULL, '/directives/debounceDirect/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'debounceDirect', '/directives/debounceDirect', NULL, '防抖指令');
INSERT INTO `sys_menu` VALUES (9, 905, NULL, '/directives/throttleDirect/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'throttleDirect', '/directives/throttleDirect', NULL, '节流指令');
INSERT INTO `sys_menu` VALUES (9, 906, NULL, '/directives/longpressDirect/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'longpressDirect', '/directives/longpressDirect', NULL, '长按指令');
INSERT INTO `sys_menu` VALUES (10, 1001, NULL, '/menu/menu1/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'menu1', '/menu/menu1', NULL, '菜单1');
INSERT INTO `sys_menu` VALUES (10, 1002, NULL, NULL, 'Menu', b'0', b'0', b'0', b'1', NULL, 'menu2', '/menu/menu2', '/menu/menu2/menu21', '菜单2');
INSERT INTO `sys_menu` VALUES (10, 1003, NULL, '/menu/menu3/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'menu3', '/menu/menu3', NULL, '菜单3');
INSERT INTO `sys_menu` VALUES (11, 1101, NULL, '/system/accountManage/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'accountManage', '/system/accountManage', NULL, '账号管理');
INSERT INTO `sys_menu` VALUES (11, 1102, NULL, '/system/roleManage/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'roleManage', '/system/roleManage', NULL, '角色管理');
INSERT INTO `sys_menu` VALUES (11, 1103, NULL, '/system/menuMange/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'menuMange', '/system/menuMange', NULL, '菜单管理');
INSERT INTO `sys_menu` VALUES (11, 1104, NULL, '/system/departmentManage/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'departmentManage', '/system/departmentManage', NULL, '部门管理');
INSERT INTO `sys_menu` VALUES (11, 1105, NULL, '/system/dictManage/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'dictManage', '/system/dictManage', NULL, '字典管理');
INSERT INTO `sys_menu` VALUES (11, 1106, NULL, '/system/timingTask/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'timingTask', '/system/timingTask', NULL, '定时任务');
INSERT INTO `sys_menu` VALUES (11, 1107, NULL, '/system/systemLog/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'systemLog', '/system/systemLog', NULL, '系统日志');
INSERT INTO `sys_menu` VALUES (12, 1201, NULL, '/link/bing/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'bing', '/link/bing', '', 'Bing 内嵌');
INSERT INTO `sys_menu` VALUES (12, 1202, NULL, '/link/gitee/index', 'Menu', b'0', b'0', b'0', b'1', 'https://gitee.com/HalseySpicy/Geeker-Admin', 'gitee', '/link/gitee', NULL, 'Gitee 仓库');
INSERT INTO `sys_menu` VALUES (5, 5010, NULL, '/assembly/draggable/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'draggable', '/assembly/draggable', NULL, '拖拽组件');
INSERT INTO `sys_menu` VALUES (201, 20101, '/proTable/useProTable', '/proTable/useProTable/detail', 'Menu', b'0', b'0', b'1', b'1', NULL, 'useProTableDetail', '/proTable/useProTable/detail/:id', NULL, 'ProTable 详情');
INSERT INTO `sys_menu` VALUES (502, 50201, '/assembly/tabs', '/assembly/tabs/detail', 'Menu', b'0', b'0', b'1', b'1', NULL, 'tabsDetail', '/assembly/tabs/detail/:id', NULL, 'Tab 详情');
INSERT INTO `sys_menu` VALUES (1002, 100201, NULL, '/menu/menu2/menu21/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'menu21', '/menu/menu2/menu21', NULL, '菜单2-1');
INSERT INTO `sys_menu` VALUES (1002, 100202, NULL, NULL, 'Menu', b'0', b'0', b'0', b'1', NULL, 'menu22', '/menu/menu2/menu22', '/menu/menu2/menu22/menu221', '菜单2-2');
INSERT INTO `sys_menu` VALUES (1002, 100203, NULL, '/menu/menu2/menu23/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'menu23', '/menu/menu2/menu23', NULL, '菜单2-3');
INSERT INTO `sys_menu` VALUES (100202, 10020201, NULL, '/menu/menu2/menu22/menu221/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'menu221', '/menu/menu2/menu22/menu221', NULL, '菜单2-2-1');
INSERT INTO `sys_menu` VALUES (100202, 10020202, NULL, '/menu/menu2/menu22/menu222/index', 'Menu', b'0', b'0', b'0', b'1', NULL, 'menu222', '/menu/menu2/menu22/menu222', NULL, '菜单2-2-2');

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource`  (
  `resource_id` int(11) NOT NULL COMMENT '权限id',
  `resource_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '权限名称',
  `resource_url` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '权限对应url',
  `resource_method` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '权限对应方法类型',
  PRIMARY KEY (`resource_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `role_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`menu_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (3, 1);
INSERT INTO `sys_role_menu` VALUES (4, 1);
INSERT INTO `sys_role_menu` VALUES (5, 1);
INSERT INTO `sys_role_menu` VALUES (6, 1);
INSERT INTO `sys_role_menu` VALUES (7, 1);
INSERT INTO `sys_role_menu` VALUES (8, 1);
INSERT INTO `sys_role_menu` VALUES (9, 1);
INSERT INTO `sys_role_menu` VALUES (10, 1);
INSERT INTO `sys_role_menu` VALUES (11, 1);
INSERT INTO `sys_role_menu` VALUES (12, 1);
INSERT INTO `sys_role_menu` VALUES (13, 1);

-- ----------------------------
-- Table structure for sys_role_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resources`;
CREATE TABLE `sys_role_resources`  (
  `resource_id` int(11) NOT NULL COMMENT '权限id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`resource_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_resources
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '密码',
  `del_flag` bit(1) NULL DEFAULT NULL COMMENT '删除标识',
  `email` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone_number` int(11) NULL DEFAULT NULL COMMENT '手机号码',
  `creat_time` datetime(6) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$eTIh9gqTGWgNZHCgk3dA9.CzITiwMCM36LGLLT/72CY/Xd7sRGlye', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`, `user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);

-- ----------------------------
-- Table structure for sys_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_roles`;
CREATE TABLE `sys_user_roles`  (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_roles
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
