package com.nmz.mapauthserver.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSysRoleMenuEntity is a Querydsl query type for SysRoleMenuEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSysRoleMenuEntity extends EntityPathBase<SysRoleMenuEntity> {

    private static final long serialVersionUID = -151117311L;

    public static final QSysRoleMenuEntity sysRoleMenuEntity = new QSysRoleMenuEntity("sysRoleMenuEntity");

    public final NumberPath<Integer> menuId = createNumber("menuId", Integer.class);

    public final NumberPath<Integer> roleId = createNumber("roleId", Integer.class);

    public QSysRoleMenuEntity(String variable) {
        super(SysRoleMenuEntity.class, forVariable(variable));
    }

    public QSysRoleMenuEntity(Path<? extends SysRoleMenuEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysRoleMenuEntity(PathMetadata metadata) {
        super(SysRoleMenuEntity.class, metadata);
    }

}

