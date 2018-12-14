package sm.digital.helpcenter.HELPCENTER.mapper;

import org.apache.ibatis.annotations.Select;

public interface HelpCenterMapper {

    @Select("SELECT status FROM janis_aurorape.wms_orders WHERE vtex_id = #{vtexId}")
    public Integer statusOrden(String vtexId);
}
