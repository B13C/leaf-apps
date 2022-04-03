package cn.gaple.rbac.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class TbAdDynamicSQLSupport {
    public static final TbAdTable tbAdTable = new TbAdTable();
    public final SqlColumn<Integer> id = tbAdTable.id;
    public final SqlColumn<String> url = tbAdTable.url;
    public final SqlColumn<Short> status = tbAdTable.status;
    public final SqlColumn<String> position = tbAdTable.position;
    public final SqlColumn<String> ext = tbAdTable.ext;
    public final SqlColumn<String> image = tbAdTable.image;

    public static final class TbAdTable extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);
        public final SqlColumn<String> url = column("url", JDBCType.VARCHAR);
        public final SqlColumn<Short> status = column("status", JDBCType.SMALLINT);
        public final SqlColumn<String> position = column("position", JDBCType.VARCHAR);
        public final SqlColumn<String> ext = column("ext", JDBCType.VARCHAR);
        public final SqlColumn<String> image = column("image", JDBCType.VARCHAR);

        public TbAdTable() {
            super("tb_ad");
        }
    }
}
