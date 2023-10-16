package com.wangrunxin.component.hibernate.reverse;

import org.hibernate.tool.api.reveng.TableIdentifier;
import org.hibernate.tool.internal.reveng.strategy.DefaultStrategy;
import org.hibernate.tool.internal.util.NameConverter;

import java.beans.Introspector;

public class ReverseStrategy extends DefaultStrategy {

    public String columnToPropertyName(TableIdentifier table, String columnName) {
        String decapitalize = Introspector.decapitalize(columnName);
        return this.keywordCheck(decapitalize);
    }

    private String keywordCheck(String possibleKeyword) {
        if (NameConverter.isReservedJavaKeyword(possibleKeyword)) {
            possibleKeyword = possibleKeyword + "_";
        }

        return possibleKeyword;
    }
}
