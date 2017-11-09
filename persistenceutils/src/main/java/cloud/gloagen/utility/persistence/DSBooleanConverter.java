package cloud.gloagen.utility.persistence;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DSBooleanConverter implements AttributeConverter<Boolean, String> {
    public DSBooleanConverter() {
    }

    @Override
    public String convertToDatabaseColumn(Boolean value) {
        return Boolean.TRUE.equals(value) ? "T" : "F";
    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
        return "TRUE".equalsIgnoreCase(value) ? Boolean.TRUE : Boolean.FALSE;
    }
}
