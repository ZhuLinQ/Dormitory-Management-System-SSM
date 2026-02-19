<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>宿舍管理系统 - 首页</title>
    <link rel="stylesheet" href="css\background.css" />
    <link rel="stylesheet" href="css/button_style.css" />
    <link rel="stylesheet" href="css/1.css" />
    <link rel="stylesheet" href="css/button_style.css" />
    <link rel="stylesheet" href="css/book.css" />
    <style>
        /* 全局样式重置与基础设置 */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* 标题容器：控制文字位于正上方 */
        .title-container {
            position: fixed; /* 相对于屏幕定位，不随滚动移动 */
            top: 20%; /* 距离屏幕顶部50% */
            left: 50%; /* 距离屏幕左侧50% */
            /* 关键：向左、向上位移自身的50%，抵消偏移 */
            transform: translate(-50%, -50%);

            /* 按钮美化样式（可选） */
            padding: 12px 24px;
            font-size: 16px;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }

        /* 标题文字样式：白体+黑色描边+阴影效果 */
        .system-title {
            color: white; /* 文字填充色（白色） */
            font-size: 30px; /* 字体大小适中 */
            font-weight: 650; /* 字体加粗，更醒目 */
            letter-spacing: 1px; /* 字间距微调，提升可读性 */
            /* 2. 文字阴影：增强层次感（水平偏移、垂直偏移、模糊度、阴影颜色） */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5),
                /* 主阴影：右下偏移，半透明黑色，柔和模糊 */ 0 0 8px
            rgba(255, 255, 255, 0.3); /* 辅助高光阴影：增强文字亮度，避免过暗 */
        }

        /* 响应式适配：手机端优化 */
        @media (max-width: 768px) {
            .title-container {
                padding: 30px 15px;
            }
            .system-title {
                font-size: 22px;
                text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.5),
                0 0 6px rgba(255, 255, 255, 0.3);
            }
        }
    </style>
</head>
<body>
<div class="container">
    <!-- 标题容器：承载核心文字，位于正上方 -->
    <div class="title-container">
        <h1 class="system-title">一个较为简单的基于SSM实现的宿舍管理系统</h1>
    </div>
    <div class="xxx">
        <div class="book">
            <a href="login.jsp" style="text-decoration: none">
                <button class="button">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 36 24">
                        <path d="m18 0 8 12 10-8-4 20H4L0 4l10 8 8-12z"></path>
                    </svg>
                    点击跳转
                </button>
            </a>
            <div class="cover">
                <p>宿舍管理系统</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
