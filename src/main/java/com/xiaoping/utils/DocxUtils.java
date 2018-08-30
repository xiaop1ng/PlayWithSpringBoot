package com.xiaoping.utils;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Text;

import javax.xml.bind.JAXBElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DocxUtils {

    private static WordprocessingMLPackage tmp;
    private static List<Object> texts = null;
    private final static int MODE_REPLACE_ALL = 0;
    private final static int MODE_REPLACE_ONCE = 1;

    public static WordprocessingMLPackage load(String path) throws Docx4JException {
        WordprocessingMLPackage template = WordprocessingMLPackage.load(new File(path));
        tmp = template;
        return template;
    }


    public static List<Object> getElements(Object obj, Class<?> toSearch) {
        List<Object> result = new ArrayList<>();
        if (obj instanceof JAXBElement) {
            obj = ((JAXBElement<?>) obj).getValue();
        }
        if (obj.getClass().equals(toSearch)) {
            result.add(obj);
        } else if (obj instanceof ContentAccessor) {
            List<?> children = ((ContentAccessor) obj).getContent();
            children.stream()
                    .forEach(child -> {
                        result.addAll(getElements(child, toSearch));
                    });
        }
        return result;
    }

    public static void attr(String placeholder, String value){
        attr(placeholder, value, MODE_REPLACE_ONCE);
    }

    public static void attr(String placeholder, String value, int mode) {
        if(texts == null) {
            texts = getElements(tmp.getMainDocumentPart(), Text.class);// holder
        }
        for (Object text : texts) {
            Text textElement = (Text) text;
            if (textElement.getValue().contains(placeholder)) {
                textElement.setValue(textElement.getValue().replace(placeholder, value));
                if(mode == MODE_REPLACE_ONCE) break;
            }
        }
    }

    public static void save(String target) throws Docx4JException {
        File f = new File(target);
        tmp.save(f);
    }

    // cmdtest method.
//    public static void main(String[] args) throws IOException, Docx4JException {
//        WordprocessingMLPackage wordTemplate = load("src/main/resources/template.docx");
//        attr("{{Line1}}", "Hello");
//        attr("{{Line2}}", "World!");
//        attr("{{Name}}", "Xiaop1ng", MODE_REPLACE_ALL);
//        save("src/main/resources/tempFile.docx");
//    }
}
