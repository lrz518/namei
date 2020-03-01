package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.CommonModel;
import com.jk.service.CommodityService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("commod")
@ComponentScan(basePackages = {"com.jk.*"})
public class CommodityController {
    @Reference
    private CommodityService entryService;
    @Autowired
    private SolrClient client;
    /*查看特价商品*/
    @RequestMapping("querycommodityT")
    public @ResponseBody
    List<CommonModel> querycommodityT() {

        return entryService.querycommodityT();
    }

    /*查看生活商品*/
    @RequestMapping("querydaily")
    public @ResponseBody
    List<CommonModel> querydaily() {
        return entryService.querydaily();
    }

    /*查看热门商品*/
    @RequestMapping("queryPopular")
    public @ResponseBody
    List<CommonModel> queryPopular() {
        return entryService.queryPopular();
    }

    /*查看本周商品*/
    @RequestMapping("queryThisweek")
    public @ResponseBody
    List<CommonModel> queryThisweek() {

        return entryService.queryThisweek();
    }

    /*查看上周*/
    @RequestMapping("queryListweek")
    public @ResponseBody
    List<CommonModel> queryListweek() {
        return entryService.queryListweek();
    }

    /*查看新鲜水果*/
    @RequestMapping("queryFresh")
    public @ResponseBody
    List<CommonModel> queryFresh() {
        return entryService.queryFresh();
    }

    /*查看推荐水果*/
    @RequestMapping("queryRecommend")
    public @ResponseBody
    List<CommonModel> queryRecommend() {
        return entryService.queryRecommend();
    }

    /*查看新鲜蔬菜*/
    @RequestMapping("queryVegetables")
    public @ResponseBody
    List<CommonModel> queryVegetables() {
        return entryService.queryVegetables();
    }

    /*查看有机蔬菜*/
    @RequestMapping("queryReVegetables")
    public @ResponseBody
    List<CommonModel> queryReVegetables() {
        return entryService.queryReVegetables();
    }

    /*查看营养早餐*/
    @RequestMapping("querybreakfast")
    public @ResponseBody
    List<CommonModel> querybreakfast() {
        return entryService.querybreakfast();
    }

    /*查看推荐*/
    @RequestMapping("queryRebreakfast")
    public @ResponseBody
    List<CommonModel> queryRebreakfast() {
        return entryService.queryRebreakfast();
    }

    /*查看零食*/
    @RequestMapping("querysnacks")
    public @ResponseBody
    List<CommonModel> querysnacks() {
        return entryService.querysnacks();
    }

    /*查看薯片*/
    @RequestMapping("querychips")
    public @ResponseBody
    List<CommonModel> querychips() {
        return entryService.querychips();
    }

    /*查看酒水*/
    @RequestMapping("querywine")
    public @ResponseBody
    List<CommonModel> querywine() {
        return entryService.querywine();
    }

    /*查看饮料*/
    @RequestMapping("querydrinks")
    public @ResponseBody
    List<CommonModel> querydrinks() {
        return entryService.querydrinks();
    }

    /*查看礼包*/
    @RequestMapping("querygiftbox")
    public @ResponseBody
    List<CommonModel> querygiftbox() {
        return entryService.querygiftbox();
    }

    /*查看节日礼盒*/
    @RequestMapping("queryolidaygift")
    public @ResponseBody
    List<CommonModel> queryolidaygift() {
        return entryService.queryolidaygift();
    }

    /*查看随机生活用品*/
    @RequestMapping("queryRedaily")
    public @ResponseBody
    List<CommonModel> queryRedaily() {
        return entryService.queryRedaily();
    }

    /*查看糖果*/
    @RequestMapping("querysugar")
    public @ResponseBody
    List<CommonModel> querysugar() {
        return entryService.querysugar();
    }

    /*查看软糖果*/
    @RequestMapping("querySoftsweets")
    public @ResponseBody
    List<CommonModel> querySoftsweets() {
        return entryService.querySoftsweets();
    }

    /*查看洗护*/
    @RequestMapping("queryWash")
    public @ResponseBody
    List<CommonModel> queryWash() {
        return entryService.queryWash();
    }

    /*查看 熟食*/
    @RequestMapping("queryCooked")
    public @ResponseBody
    List<CommonModel> queryCooked() {
        return entryService.queryCooked();
    }
    /*查看solr数据*/
    @RequestMapping("solrquery")
    public @ResponseBody Map<String, Object> search(  String solrvalue){
           Map<String,Object> map1 =  new HashMap<>();
        try {
            SolrQuery params = new SolrQuery();

            if (solrvalue!=null && !"".equals(solrvalue)){
                //查询条件, 这里的 q 对应 下面图片标红的地方
                params.set("q",solrvalue);
            }else{
                params.set("q","*:*");
            }

           /* //过滤条件
            params.set("fq", "product_price:[100 TO 100000]");*/

            //排序
            params.addSort("commoprice", SolrQuery.ORDER.asc);

            //分页
            params.setStart(0);
            params.setRows(20);

            //默认域
            params.set("df", "commodityname");

            //只查询指定域
            //params.set("fl", "id,product_title,product_price");

            //高亮
            //打开开关
            params.setHighlight(true);
            //指定高亮域
            params.addHighlightField("commodityname");
            //设置前缀
            params.setHighlightSimplePre("<span style='color:red'>");
            //设置后缀
            params.setHighlightSimplePost("</span>");

            //查询后返回
            QueryResponse queryResponse = client.query("core1",params);

            SolrDocumentList results = queryResponse.getResults();

            long numFound = results.getNumFound();


/*获取高亮显示的结果, 高亮显示的结果和查询结果是分开放的*/
            Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            List<CommonModel> list1 = new ArrayList<>();
            for (SolrDocument result : results) {

                CommonModel commonModel = new CommonModel();

                String highFile="";

                //.out.println(result.get("id"));
               // System.out.println(result.get("product_title"));
                //System.out.println(result.get("product_num"));
                //System.out.println(result.get("product_price"));
                //System.out.println(result.get("product_image"));

                Map<String, List<String>> map = highlight.get(result.get("id"));
                List<String> list = map.get("commodityname");


                if (list==null){
                    highFile=result.get("commodityname").toString();
                }else{
                    highFile=list.get(0);
                }

                commonModel.setCommodity((String)result.get("commodity"));
                commonModel.setCommodityid(Integer.parseInt(result.get("id").toString()));
                commonModel.setCommoditydesc((String) result.get("commoditydesc"));
                commonModel.setCommodityguige((String) result.get("cmmodityguige"));
                commonModel.setCommodityimg((String) result.get("commodityimg"));
                commonModel.setCommodityname((String) result.get("commodityname"));

                commonModel.setCommoditytype((String) result.get("setcommoditytype"));


                list1.add(commonModel);
            }
            map1.put("total",numFound);
            map1.put("rows",list1);
            return map1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /*商品详情页面*/
    @RequestMapping("tiaoxiangqing")
    public @ResponseBody  ModelAndView tiaoxiangqing(Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id",id);
        modelAndView.setViewName("xiangqing");
        return modelAndView;
    }
    /*查对应商品*/

    @RequestMapping("queryshangp")
    public @ResponseBody
    List<CommonModel> queryshangp(Integer id) {
        return entryService.queryshangp(id);
    }
    /*跳转商品页面*/
    @RequestMapping("tiaoshangp")
    public @ResponseBody  ModelAndView tiaoshangp(Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("classification");
        return  modelAndView;
    }
}


