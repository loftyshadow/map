package com.nmz.mapauthserver.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSysUserRoleEntity is a Querydsl query type for SysUserRoleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSysUserRoleEntity extends EntityPathBase<SysUserRoleEntity> {

    private static final long serialVersionUID = 576365805L;

    public static final QSysUserRoleEntity sysUserRoleEntity = new QSysUserRoleEntity("sysUserRoleEntity");

    public final NumberPath<Integer> roleId = createNumber("roleId", Integer.class);

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public QSysUserRoleEntity(String variable) {
        super(SysUserRoleEntity.class, forVariable(variable));
    }

    public QSysUserRoleEntity(Path<? extends SysUserRoleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysUserRoleEntity(PathMetadata metadata) {
        super(SysUserRoleEntity.class, metadata);
    }

}

