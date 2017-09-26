package io.gloagen.web.dakamon.provider;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JSONBodyWritter implements MessageBodyWriter<Object> {
    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return false;
    }

    @Override
    public long getSize(Object o, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo(Object o, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream)
            throws IOException, WebApplicationException {

    }
}
