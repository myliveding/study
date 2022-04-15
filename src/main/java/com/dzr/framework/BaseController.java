package com.dzr.framework;

import com.dzr.framework.mybatis.PageView;
import com.dzr.util.DataUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller层的基类，第一个版本中主要提供分页方法
 *
 * @author zhangsheng
 *         <p/>
 *         date：2014-2-17
 */
@Slf4j
public class BaseController {
    protected PageView pageView = null;

    public PageView getPageView(String pageNow, String pageSize) {
        if (DataUtils.isEmpty(pageNow)) {
            pageView = new PageView(1);
        } else {
            int currentPage = 1;
            try {
                currentPage = Integer.parseInt(pageNow);
            } catch (NumberFormatException e) {
                log.error("分页异常:" + e.getMessage());
            }
            pageView = new PageView(currentPage);
        }
        if (DataUtils.isEmpty(pageSize)) {
            pageSize = "10";
        }
        int pageSizeInt = 10;
        try {
            pageSizeInt = Integer.parseInt(pageSize);
        } catch (NumberFormatException e) {
            log.error("分页异常:" + e.getMessage());
        }
        pageView.setPageSize(pageSizeInt);
        return pageView;
    }

//    /**
//     * @ModelAttribute 这个注解作用.每执行controllor前都会先执行这个方法
//     * date：2014-5-25
//     */
    /*@ModelAttribute
    public void init(HttpServletRequest request){
		String path = Common.BACKGROUND_PATH;
		Object ep = request.getSession().getAttribute("basePath");
		if(ep!=null){
			if(!path.endsWith(ep.toString())){
				Common.BACKGROUND_PATH = "/WEB-INF/jsp/background"+ep;
			}
		}
		
	}*/
    protected Map<String, Object> successResult(Object object) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 0);
        map.put("msg", "ok");
        map.put("data", object);
        return map;
    }

    protected Map<String, Object> successResult(long total, Object object) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 0);
        map.put("msg", "ok");
        map.put("data", object);
        map.put("recordsTotal", total);
        map.put("recordsFiltered", total);

        return map;
    }
}