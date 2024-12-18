package com.hyperionml.mapper;

import com.hyperionml.pojo.Bearing;
import com.hyperionml.pojo.HistoryStatus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface BearingMapper {

    @Select("select * from db_bearing.bearing")
    List<Bearing> selectAllBearing();

    @Select("select * from db_bearing.history_status where sid = #{sid} and datetime = #{datetime}")
    HistoryStatus selectHisStaBySidAndDatetime(int sid, LocalDate datetime);

    @Select("select * from db_bearing.bearing where sid = #{sid}")
    Bearing selectBearingBySid(int sid);

    @Insert("insert into db_bearing.history_status (sid, err_count, err_msg, datetime) " +
            "values (#{sid}, #{errCount}, #{errMsg}, #{datetime})")
    int insertHisSta(HistoryStatus historyStatus);


    @Update("update db_bearing.history_status set err_count = #{errCount}, err_msg = #{errMsg} " +
            "where sid = #{sid} and datetime = #{datetime}")
    int updateHisSta(HistoryStatus historyStatus);
}
