package spring_board.ex.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import spring_board.ex.dto.BDto;
import spring_board.ex.util.Constant;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class BDao {

    //    DataSource dataSource;
    JdbcTemplate jdbcTemplate = null;

    public BDao() {
        this.jdbcTemplate = Constant.jdbcTemplate;
    }

    public void write(final String bName, final String bTitle, final String bContent) {
        this.jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, bName);
                preparedStatement.setString(2, bTitle);
                preparedStatement.setString(3, bContent);

                return preparedStatement;
            }
        });
    }

    public ArrayList<BDto> list() {
        ArrayList<BDto> dtoArrayList = null;
        String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
        dtoArrayList = (ArrayList<BDto>) jdbcTemplate.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));

        return dtoArrayList;
    }

    public BDto contentView(String id) {
        upHit(id);

        String query = "select * from mvc_board where bId =" + id;
        BDto dto = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));

        return dto;
    }

    private void upHit(final String bId) {
        String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
        jdbcTemplate.update(query, new PreparedStatementSetter() {

            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, Integer.parseInt(bId));
            }
        });
    }

    public void modify(final String bId, final String bName, final String bTitle, final String bContent) {
        String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
        jdbcTemplate.update(query, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, bName);
                preparedStatement.setString(2, bTitle);
                preparedStatement.setString(3, bContent);
                preparedStatement.setInt(4, Integer.parseInt(bId));
            }
        });
    }

    public void delete(final String bId) {
        String query = "delete from mvc_board where bId = ?";
        jdbcTemplate.update(query, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, bId);
            }
        });
    }

    public BDto reply_view(String bId) {
        BDto dto = null;
        String query = "select * from mvc_board where bId =" + bId;
        dto = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
        return dto;
    }

    public void reply(final String bId, final String bName, final String bTitle, final String bContent, final String bGroup, final String bStep, final String bIndent) {
        replyShape(bGroup, bStep);
        String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
        this.jdbcTemplate.update(query, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, bName);
                preparedStatement.setString(2, bTitle);
                preparedStatement.setString(3, bContent);
                preparedStatement.setInt(4, Integer.parseInt(bGroup));
                preparedStatement.setInt(5, Integer.parseInt(bStep) + 1);
                preparedStatement.setInt(6, Integer.parseInt(bIndent) + 1);
            }
        });
    }

    private void replyShape(final String bGroup, final String bStep) {
        String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
        jdbcTemplate.update(query, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, bGroup);
                preparedStatement.setString(2, bStep);
            }
        });
    }
}
