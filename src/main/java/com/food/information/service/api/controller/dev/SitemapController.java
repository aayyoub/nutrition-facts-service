package com.food.information.service.api.controller.dev;

import com.food.information.service.dataaccess.jpa.entity.SearchTermEntity;
import com.food.information.service.dataaccess.jpa.repository.FoodRepository;
import com.food.information.service.domain.seo.SeoUrlBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

@RestController
@Profile("dev")
public class SitemapController {
    private static final String FILE_BEGINNING =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n" +
                    "<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n\n";

    private static final String URL_ENTRY =
            "\t<url>\n" +
                    "\t\t<loc>%s</loc>\n" +
                    "\t\t<changefreq>weekly</changefreq>\n" +
                    "\t\t<lastmod>2020-03-01T22:01:35+00:00</lastmod>\n" +
                    "\t</url>\n\n";

    private static final String FILE_ENDING =
            "</urlset>\n";

    private final FoodRepository foodRepository;
    private final SeoUrlBuilder seoUrlBuilder;

    public SitemapController(FoodRepository foodRepository, SeoUrlBuilder seoUrlBuilder) {
        this.foodRepository = foodRepository;
        this.seoUrlBuilder = seoUrlBuilder;
    }

    @CrossOrigin
    @GetMapping("/buildSitemap")
    public String buildSitemap() throws Exception {
        List<SearchTermEntity> allLinks = foodRepository.getAllLinks();

        Writer fileWriter = new FileWriter("sitemap.xml");

        fileWriter.append(FILE_BEGINNING);

        String mainUrl = String.format(URL_ENTRY, "https://www.nutritionfacts.io/");

        fileWriter.append(mainUrl);

        for (SearchTermEntity allLink : allLinks) {
            String url = seoUrlBuilder.buildUrl(allLink.getFoodDescriptionId(), allLink.getLongDescription());

            String urlEntry = String.format(URL_ENTRY, url);

            fileWriter.append(urlEntry);
        }

        fileWriter.append(FILE_ENDING);

        fileWriter.close();

        return "COMPLETE";
    }
}
