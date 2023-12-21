/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.14
 Source Server Type    : MySQL
 Source Server Version : 80200 (8.2.0)
 Source Host           : 192.168.1.14:3306
 Source Schema         : map

 Target Server Type    : MySQL
 Target Server Version : 80200 (8.2.0)
 File Encoding         : 65001

 Date: 21/12/2023 15:42:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `city_id` bigint NOT NULL,
  `city_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `parent_city_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`city_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city
-- ----------------------------

-- ----------------------------
-- Table structure for city_entity
-- ----------------------------
DROP TABLE IF EXISTS `city_entity`;
CREATE TABLE `city_entity`  (
  `city_id` bigint NOT NULL,
  `city_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `parent_city_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`city_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city_entity
-- ----------------------------

-- ----------------------------
-- Table structure for mapo_review
-- ----------------------------
DROP TABLE IF EXISTS `mapo_review`;
CREATE TABLE `mapo_review`  (
  `review_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `review_content` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `review_create_time` datetime(6) NULL DEFAULT NULL,
  `review_update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`review_id`, `user_id`) USING BTREE,
  UNIQUE INDEX `UK_3jk4ugaxd00d32vk35udyoevg`(`review_id` ASC) USING BTREE,
  UNIQUE INDEX `UK_1pwe3kxk97vo0fqh5kp63s5jl`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mapo_review
-- ----------------------------

-- ----------------------------
-- Table structure for scenic_spot
-- ----------------------------
DROP TABLE IF EXISTS `scenic_spot`;
CREATE TABLE `scenic_spot`  (
  `city_id` bigint NOT NULL,
  `scenic_spot_id` bigint NOT NULL,
  `scenic_spot_describe` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `scenic_spot_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`city_id`, `scenic_spot_id`) USING BTREE,
  UNIQUE INDEX `UK_tn2qxm5e3vv3n582ov4n8ylsd`(`city_id` ASC) USING BTREE,
  UNIQUE INDEX `UK_dyjttgm0tkwkr83p4rccv5xxd`(`scenic_spot_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scenic_spot
-- ----------------------------

-- ----------------------------
-- Table structure for scenic_spot_scenic_spot_type
-- ----------------------------
DROP TABLE IF EXISTS `scenic_spot_scenic_spot_type`;
CREATE TABLE `scenic_spot_scenic_spot_type`  (
  `scenic_spot_type_id` bigint NOT NULL,
  `scenic_spot_id` bigint NOT NULL,
  PRIMARY KEY (`scenic_spot_type_id`, `scenic_spot_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scenic_spot_scenic_spot_type
-- ----------------------------

-- ----------------------------
-- Table structure for scenic_spot_type
-- ----------------------------
DROP TABLE IF EXISTS `scenic_spot_type`;
CREATE TABLE `scenic_spot_type`  (
  `scenic_spot_type_id` bigint NOT NULL AUTO_INCREMENT,
  `scenic_spot_parent_type` tinyint NULL DEFAULT NULL,
  `scenic_spot_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`scenic_spot_type_id`) USING BTREE,
  CONSTRAINT `scenic_spot_type_chk_1` CHECK (`scenic_spot_parent_type` between 0 and 7)
) ENGINE = InnoDB AUTO_INCREMENT = 104 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scenic_spot_type
-- ----------------------------
INSERT INTO `scenic_spot_type` VALUES (1, 0, '平原');
INSERT INTO `scenic_spot_type` VALUES (2, 0, '戈壁');
INSERT INTO `scenic_spot_type` VALUES (3, 0, '峡谷');
INSERT INTO `scenic_spot_type` VALUES (4, 0, '峰林');
INSERT INTO `scenic_spot_type` VALUES (5, 0, '钙华');
INSERT INTO `scenic_spot_type` VALUES (6, 0, '石柱');
INSERT INTO `scenic_spot_type` VALUES (7, 0, '火山');
INSERT INTO `scenic_spot_type` VALUES (8, 0, '岩石');
INSERT INTO `scenic_spot_type` VALUES (9, 0, '雪山');
INSERT INTO `scenic_spot_type` VALUES (10, 0, '绿洲');
INSERT INTO `scenic_spot_type` VALUES (11, 0, '沙地');
INSERT INTO `scenic_spot_type` VALUES (12, 0, '雅丹');
INSERT INTO `scenic_spot_type` VALUES (13, 0, '山地');
INSERT INTO `scenic_spot_type` VALUES (14, 0, '丘陵');
INSERT INTO `scenic_spot_type` VALUES (15, 0, '高原');
INSERT INTO `scenic_spot_type` VALUES (16, 0, '盆地');
INSERT INTO `scenic_spot_type` VALUES (17, 0, '喀斯特');
INSERT INTO `scenic_spot_type` VALUES (18, 0, '洞穴');
INSERT INTO `scenic_spot_type` VALUES (19, 0, '石林');
INSERT INTO `scenic_spot_type` VALUES (20, 0, '丹霞');
INSERT INTO `scenic_spot_type` VALUES (21, 0, '彩丘');
INSERT INTO `scenic_spot_type` VALUES (22, 1, '湿地');
INSERT INTO `scenic_spot_type` VALUES (23, 1, '礁石');
INSERT INTO `scenic_spot_type` VALUES (24, 1, '冰川');
INSERT INTO `scenic_spot_type` VALUES (25, 1, '湖泊');
INSERT INTO `scenic_spot_type` VALUES (26, 1, '冲积扇');
INSERT INTO `scenic_spot_type` VALUES (27, 1, '三角洲');
INSERT INTO `scenic_spot_type` VALUES (28, 1, '岛屿');
INSERT INTO `scenic_spot_type` VALUES (29, 1, '半岛');
INSERT INTO `scenic_spot_type` VALUES (30, 1, '海岸');
INSERT INTO `scenic_spot_type` VALUES (31, 1, '河流');
INSERT INTO `scenic_spot_type` VALUES (32, 1, '瀑布');
INSERT INTO `scenic_spot_type` VALUES (33, 2, '热带雨林');
INSERT INTO `scenic_spot_type` VALUES (34, 2, '草原');
INSERT INTO `scenic_spot_type` VALUES (35, 2, '牧场');
INSERT INTO `scenic_spot_type` VALUES (36, 2, '林场');
INSERT INTO `scenic_spot_type` VALUES (37, 2, '林地');
INSERT INTO `scenic_spot_type` VALUES (38, 2, '农场');
INSERT INTO `scenic_spot_type` VALUES (39, 2, '庄园');
INSERT INTO `scenic_spot_type` VALUES (40, 2, '花地');
INSERT INTO `scenic_spot_type` VALUES (41, 2, '梯田');
INSERT INTO `scenic_spot_type` VALUES (42, 3, '观星地');
INSERT INTO `scenic_spot_type` VALUES (43, 3, '海市蜃楼');
INSERT INTO `scenic_spot_type` VALUES (44, 3, '云雾');
INSERT INTO `scenic_spot_type` VALUES (45, 3, '极光');
INSERT INTO `scenic_spot_type` VALUES (46, 3, '雾松');
INSERT INTO `scenic_spot_type` VALUES (47, 3, '星空天象');
INSERT INTO `scenic_spot_type` VALUES (48, 4, '寺庙');
INSERT INTO `scenic_spot_type` VALUES (49, 4, '古塔');
INSERT INTO `scenic_spot_type` VALUES (50, 4, '古村');
INSERT INTO `scenic_spot_type` VALUES (51, 4, '古镇');
INSERT INTO `scenic_spot_type` VALUES (52, 4, '陵墓');
INSERT INTO `scenic_spot_type` VALUES (53, 4, '宫殿');
INSERT INTO `scenic_spot_type` VALUES (54, 4, '红色景区');
INSERT INTO `scenic_spot_type` VALUES (55, 4, '化石景观');
INSERT INTO `scenic_spot_type` VALUES (56, 4, '古典园林');
INSERT INTO `scenic_spot_type` VALUES (57, 4, '古道');
INSERT INTO `scenic_spot_type` VALUES (58, 4, '古楼');
INSERT INTO `scenic_spot_type` VALUES (59, 4, '祠堂');
INSERT INTO `scenic_spot_type` VALUES (60, 4, '岩壁画');
INSERT INTO `scenic_spot_type` VALUES (61, 4, '遗址');
INSERT INTO `scenic_spot_type` VALUES (62, 4, '碑石牌坊');
INSERT INTO `scenic_spot_type` VALUES (63, 4, '石窟');
INSERT INTO `scenic_spot_type` VALUES (64, 4, '石刻');
INSERT INTO `scenic_spot_type` VALUES (65, 4, '民居');
INSERT INTO `scenic_spot_type` VALUES (66, 4, '名人故居故里');
INSERT INTO `scenic_spot_type` VALUES (67, 4, '民俗村');
INSERT INTO `scenic_spot_type` VALUES (68, 4, '纪念园 (馆/碑)');
INSERT INTO `scenic_spot_type` VALUES (69, 4, '古城');
INSERT INTO `scenic_spot_type` VALUES (70, 5, '工业基地');
INSERT INTO `scenic_spot_type` VALUES (71, 5, '公园');
INSERT INTO `scenic_spot_type` VALUES (72, 5, '城市建筑');
INSERT INTO `scenic_spot_type` VALUES (73, 5, '现代园林');
INSERT INTO `scenic_spot_type` VALUES (74, 5, '铁路');
INSERT INTO `scenic_spot_type` VALUES (75, 5, '高速');
INSERT INTO `scenic_spot_type` VALUES (76, 5, '国道');
INSERT INTO `scenic_spot_type` VALUES (77, 5, '矿山公园');
INSERT INTO `scenic_spot_type` VALUES (78, 5, '桥梁');
INSERT INTO `scenic_spot_type` VALUES (79, 5, '运河');
INSERT INTO `scenic_spot_type` VALUES (80, 5, '水电站');
INSERT INTO `scenic_spot_type` VALUES (81, 5, '大坝');
INSERT INTO `scenic_spot_type` VALUES (82, 5, '水库');
INSERT INTO `scenic_spot_type` VALUES (83, 5, '电视塔');
INSERT INTO `scenic_spot_type` VALUES (84, 5, '农业基地');
INSERT INTO `scenic_spot_type` VALUES (85, 5, '公路');
INSERT INTO `scenic_spot_type` VALUES (86, 6, '城区');
INSERT INTO `scenic_spot_type` VALUES (87, 6, '边城');
INSERT INTO `scenic_spot_type` VALUES (88, 6, '口岸');
INSERT INTO `scenic_spot_type` VALUES (89, 6, '博物馆');
INSERT INTO `scenic_spot_type` VALUES (90, 6, '科技馆');
INSERT INTO `scenic_spot_type` VALUES (91, 6, '展览馆');
INSERT INTO `scenic_spot_type` VALUES (92, 6, '影视城');
INSERT INTO `scenic_spot_type` VALUES (93, 6, '游乐园');
INSERT INTO `scenic_spot_type` VALUES (94, 6, '温泉');
INSERT INTO `scenic_spot_type` VALUES (95, 7, '世界自然遗产');
INSERT INTO `scenic_spot_type` VALUES (96, 7, '世界文化遗产');
INSERT INTO `scenic_spot_type` VALUES (97, 7, '世界文化与自然双重遗产');
INSERT INTO `scenic_spot_type` VALUES (98, 7, '世界文化景观');
INSERT INTO `scenic_spot_type` VALUES (99, 7, '中国国家森林公园名录');
INSERT INTO `scenic_spot_type` VALUES (100, 7, '中国世界级自然保护区名录');
INSERT INTO `scenic_spot_type` VALUES (101, 7, '中国地质公园名录');
INSERT INTO `scenic_spot_type` VALUES (102, 7, '中国国家级自然保护区名录');
INSERT INTO `scenic_spot_type` VALUES (103, 7, '国家级非物质文化遗产名录');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `parent_id` bigint NOT NULL,
  `menu_id` bigint NOT NULL AUTO_INCREMENT,
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
) ENGINE = InnoDB AUTO_INCREMENT = 10020203 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

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
  `resource_id` bigint NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '权限名称',
  `resource_url` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '权限对应url',
  `resource_method` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '权限对应方法类型',
  PRIMARY KEY (`resource_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `menu_id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`menu_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

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
  `resource_id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`resource_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_resources
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '密码',
  `del_flag` bit(1) NULL DEFAULT NULL COMMENT '删除标识',
  `email` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone_number` int NULL DEFAULT NULL COMMENT '手机号码',
  `creat_time` datetime(6) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$eTIh9gqTGWgNZHCgk3dA9.CzITiwMCM36LGLLT/72CY/Xd7sRGlye', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`role_id`, `user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);

-- ----------------------------
-- Table structure for todo_record
-- ----------------------------
DROP TABLE IF EXISTS `todo_record`;
CREATE TABLE `todo_record`  (
  `record_id` bigint NOT NULL AUTO_INCREMENT,
  `record_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `record_is_delete` bit(1) NULL DEFAULT NULL,
  `record_locked` bit(1) NULL DEFAULT NULL,
  `record_create_time` datetime(6) NULL DEFAULT NULL,
  `record_update_time` datetime(6) NULL DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of todo_record
-- ----------------------------
INSERT INTO `todo_record` VALUES (22, 'title_7fb73fccb6fd', b'0', b'0', '2023-11-28 20:46:32.571000', '2023-11-28 20:46:32.571000', 0);
INSERT INTO `todo_record` VALUES (23, 'title_7fb73fccb6fd', b'0', b'0', '2023-11-28 20:47:59.581000', '2023-11-28 20:47:59.581000', 0);

-- ----------------------------
-- Table structure for todo_record_detail
-- ----------------------------
DROP TABLE IF EXISTS `todo_record_detail`;
CREATE TABLE `todo_record_detail`  (
  `record_id` bigint NOT NULL,
  `record_detail_id` bigint NOT NULL AUTO_INCREMENT,
  `detail_checked` bit(1) NULL DEFAULT NULL,
  `detail_is_delete` bit(1) NULL DEFAULT NULL,
  `detail_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `detail_create_time` datetime(6) NULL DEFAULT NULL,
  `detail_update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`record_detail_id`, `record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of todo_record_detail
-- ----------------------------
INSERT INTO `todo_record_detail` VALUES (0, 26, b'0', b'0', 'text_369d6fec3129', '2023-11-28 20:46:32.710000', '2023-11-28 20:46:32.710000');
INSERT INTO `todo_record_detail` VALUES (0, 27, b'0', b'0', 'text_369d6fec3129', '2023-11-28 20:47:59.620000', '2023-11-28 20:47:59.620000');

-- ----------------------------
-- Table structure for todo_review
-- ----------------------------
DROP TABLE IF EXISTS `todo_review`;
CREATE TABLE `todo_review`  (
  `review_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `review_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`review_id`, `user_id`) USING BTREE,
  UNIQUE INDEX `UK_o1qverbq1939pnd7fkekriei0`(`review_id` ASC) USING BTREE,
  UNIQUE INDEX `UK_3vr1p92fl2vr9hwwccucu4bmb`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of todo_review
-- ----------------------------

-- ----------------------------
-- Table structure for visited_city
-- ----------------------------
DROP TABLE IF EXISTS `visited_city`;
CREATE TABLE `visited_city`  (
  `user_id` bigint NOT NULL,
  `review_id` bigint NOT NULL,
  `visit_city_time` date NULL DEFAULT NULL,
  `visited_city_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`, `review_id`) USING BTREE,
  UNIQUE INDEX `UK_r3mob0pugmkubijejcor6egpn`(`user_id` ASC) USING BTREE,
  UNIQUE INDEX `UK_fgv2yr45f4oo7e54raq20rmdh`(`review_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of visited_city
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
