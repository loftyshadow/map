package com.nmz.mapauthserver.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSysUserRolesEntity is a Querydsl query type for SysUserRolesEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSysUserRolesEntity extends EntityPathBase<SysUserRolesEntity> {

    private static final long serialVersionUID = 1678915212L;

    public static final QSysUserRolesEntity sysUserRolesEntity = new QSysUserRolesEntity("sysUserRolesEntity");

    public final NumberPath<Integer> roleId = createNumber("roleId", Integer.class);

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public QSysUserRolesEntity(String variable) {
        super(SysUserRolesEntity.class, forVariable(variable));
    }

    public QSysUserRolesEntity(Path<? extends SysUserRolesEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysUserRolesEntity(PathMetadata metadata) {
        super(SysUserRolesEntity.class, metadata);
    }

}

