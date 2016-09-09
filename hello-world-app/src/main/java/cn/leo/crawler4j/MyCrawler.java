package cn.leo.crawler4j;

import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

@Slf4j
public class MyCrawler extends WebCrawler {
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
            + "|png|mp3|mp3|zip|gz))$");

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches()
               && href.contains("bjut.edu.cn/");
    }
    
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
//        log.debug("URL: {}" , url);

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
//            String html = htmlParseData.getHtml();
//            Set<WebURL> links = htmlParseData.getOutgoingUrls();
            convert(text,url);
        }
    }

    private void convert(String text,String url) {
        String[] texts=text.split("\n");
        int i=0;
        for (String string : texts) {
            if(StringUtils.isBlank(string)){
                continue;
            }
            string=string.trim();
            if(string.length()<80){
                continue;
            }
            log.debug("{} string length:{}",i++,string.length());
            log.debug(string);
        }
        if(i>0){
            log.debug("url:{}",url);
        }
    }
}
