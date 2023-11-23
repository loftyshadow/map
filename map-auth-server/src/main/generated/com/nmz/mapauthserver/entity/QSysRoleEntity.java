package com.nmz.mapauthserver.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSysRoleEntity is a Querydsl query type for SysRoleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSysRoleEntity extends EntityPathBase<SysRoleEntity> {

    private static final long serialVersionUID = -539317438L;

    public static final QSysRoleEntity sysRoleEntity = new QSysRoleEntity("sysRoleEntity");

    public final NumberPath<Integer> roleId = createNumber("roleId", Integer.class);

    public final StringPath roleName = createString("roleName");

    public QSysRoleEntity(String variable) {
        super(SysRoleEntity.class, forVariable(variable));
    }

    public QSysRoleEntity(Path<? extends SysRoleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysRoleEntity(PathMetadata metadata) {
        super(SysRoleEntity.class, metadata);
    }

}

