package com.app.reservation.util;

import com.querydsl.jpa.sql.JPASQLQuery;
import com.querydsl.sql.SQLTemplates;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import java.text.MessageFormat;

@Slf4j
@RequiredArgsConstructor
public class JpaHelper {

    private static final String SQL_NAME_TAG_FORMAT = "/* {0} - {1} - {2} */";
    @NotNull
    private final Environment env;
    @NotNull
    private final EntityManager entityManager;
    @NotNull
    private final SQLTemplates sqlTemplates;
    private static String applicationName;

    @Value("${spring.application.name}")
    public void setApplicationName(String applicationName) {
        JpaHelper.applicationName = applicationName;
    }

    public static String getSqlNameTagComment(Class c) {
        if (c != null && (c.isAnonymousClass() || c.isLocalClass())) {
            if (c.getEnclosingMethod() != null && c.getEnclosingClass() != null) {
                return MessageFormat.format(SQL_NAME_TAG_FORMAT, applicationName, c.getEnclosingClass().getSimpleName(), c.getEnclosingMethod().getName());
            }
        }
        return MessageFormat.format(SQL_NAME_TAG_FORMAT, "", "");
    }

    public static <T> Boolean isY(T field, Boolean defaultValue) {
        if (field == null) {
            return defaultValue;
        } else {
            return field.toString().equalsIgnoreCase("Y");
        }
    }

    public static <T> T nvl(T object, T defaultValue) {
        return object != null ? object : defaultValue;
    }

    public JPASQLQuery<?> query() {
        return new JPASQLQuery<Void>(entityManager, sqlTemplates);
    }
}
