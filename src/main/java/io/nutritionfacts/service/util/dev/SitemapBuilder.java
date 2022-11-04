package io.nutritionfacts.service.util.dev;

import io.nutritionfacts.service.dataaccess.jpa.repository.FoodRepository;
import io.nutritionfacts.service.domain.seo.SeoUrlBuilder;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SitemapBuilder {
    private final FoodRepository foodRepository;
    private final SeoUrlBuilder seoUrlBuilder;

    public SitemapBuilder(FoodRepository foodRepository, SeoUrlBuilder seoUrlBuilder) {
        this.foodRepository = foodRepository;
        this.seoUrlBuilder = seoUrlBuilder;
    }

    public void buildSitemap() throws Exception {
        Document document = buildDocument();

        Element rootElement = createRootElement(document);

        document.appendChild(rootElement);

        Element home = buildUrl(document, "https://www.nutritionfacts.io");
        rootElement.appendChild(home);

        foodRepository.getAllLinks().forEach((searchTermEntity) -> {
            Element url = buildUrl(document, seoUrlBuilder.buildUrl(searchTermEntity.getLongDescription()));
            rootElement.appendChild(url);
        });

        writeDocument(document);
    }

    private Document buildDocument() throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        return documentBuilder.newDocument();
    }

    private Element createRootElement(Document document) {
        Element rootElement = document.createElement("urlset");
        rootElement.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "http://www.sitemaps.org/schemas/sitemap/0.9");

        return rootElement;
    }

    private Element buildUrl(Document document, String loc) {
        Element url = document.createElement("url");

        Element location = document.createElement("loc");
        location.appendChild(document.createTextNode(loc));
        url.appendChild(location);

        Element changeFrequency = document.createElement("changefreq");
        changeFrequency.appendChild(document.createTextNode("weekly"));
        url.appendChild(changeFrequency);

        Element lastModified = document.createElement("lastmod");
        lastModified.appendChild(document.createTextNode(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
        url.appendChild(lastModified);

        return url;
    }

    private void writeDocument(Document document) throws Exception {
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult("sitemap.xml");

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(source, result);
    }
}
