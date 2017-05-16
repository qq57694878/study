package com.vjsp;

import com.dhc.tools.api.ParseTable;
import com.dhc.tools.dbmeta.Table;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
public class ParseTableTest extends BaseTest{
    @Test
    public void testGetTableMeta(){

        ParseTable parseTable = new ParseTable(this.config);
        try {
            List<Table> list = parseTable.parseTableMeta();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
