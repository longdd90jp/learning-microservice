package dr.app.backend.registration.domain.entity;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "department")
public class Department extends BasicEntity{
    /** 所属ID */
    @Id
    private String id;
    /** 移行元ID */
    private String oldId;
    /** 所属名 */
    private String name;
    /** サブ表示 */
    private String displayName;
    /** path department */
    private String path;
    /** 子階層の所属 */
    @DBRef
    private List<Department> children = Lists.newArrayList();

    public Department() {
    }

    public Department(Department department)
    {
        this.id = department.getId();
        this.name = department.getName();
        this.displayName = department.getDisplayName();
        this.path = department.getPath();
    }

    public List<Department> addChild(Department department) {
        children.add(department);
        return children;
    }

    public List<Department> deleteChild(Department department) {
        if (children.contains(department)) {
            children.remove(department);
        }
        return children;
    }
}
