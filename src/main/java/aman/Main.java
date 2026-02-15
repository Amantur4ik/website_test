package aman;

import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> data =
                    mapper.readValue(
                            Main.class.getClassLoader().getResourceAsStream("user.json"),
                            Map.class
                    );


            Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources"));
            cfg.setDefaultEncoding("UTF-8");

            Template template = cfg.getTemplate("template.ftl");

            Writer writer = new FileWriter("output.html");
            template.process(data, writer);
            writer.close();

            System.out.println("✅ HTML created: output.html");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
