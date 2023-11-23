package com.nmz.mapauthserver.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSysRoleResourcesEntity is a Querydsl query type for SysRoleResourcesEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSysRoleResourcesEntity extends EntityPathBase<SysRoleResourcesEntity> {

    private static final long serialVersionUID = -1232883223L;

    public static final QSysRoleResourcesEntity sysRoleResourcesEntity = new QSysRoleResourcesEntity("sysRoleResourcesEntity");

    public final NumberPath<Integer> resourceId = createNumber("resourceId", Integer.class);

    public final NumberPath<Integer> roleId = createNumber("roleId", Integer.class);

    public QSysRoleResourcesEntity(String variable) {
        super(SysRoleResourcesEntity.class, forVariable(variable));
    }

    public QSysRoleResourcesEntity(Path<? extends SysRoleResourcesEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysRoleResourcesEntity(PathMetadata metadata) {
        super(SysRoleResourcesEntity.class, metadata);
    }

}

