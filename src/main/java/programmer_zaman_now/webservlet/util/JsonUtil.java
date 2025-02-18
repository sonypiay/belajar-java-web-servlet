package programmer_zaman_now.webservlet.util;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static ObjectMapper objectMapper() {
        return OBJECT_MAPPER
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    }
}
