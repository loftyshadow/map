package com.nmz.mapauthserver.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSysMenuEntity is a Querydsl query type for SysMenuEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSysMenuEntity extends EntityPathBase<SysMenuEntity> {

    private static final long serialVersionUID = 1843735915L;

    public static final QSysMenuEntity sysMenuEntity = new QSysMenuEntity("sysMenuEntity");

    public final StringPath activeMenu = createString("activeMenu");

    public final StringPath component = createString("component");

    public final StringPath icon = createString("icon");

    public final BooleanPath isAffix = createBoolean("isAffix");

    public final BooleanPath isFull = createBoolean("isFull");

    public final BooleanPath isHide = createBoolean("isHide");

    public final BooleanPath isKeepAlive = createBoolean("isKeepAlive");

    public final StringPath isLink = createString("isLink");

    public final NumberPath<Integer> menuId = createNumber("menuId", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> parentId = createNumber("parentId", Integer.class);

    public final StringPath path = createString("path");

    public final StringPath redirect = createString("redirect");

    public final StringPath title = createString("title");

    public QSysMenuEntity(String variable) {
        super(SysMenuEntity.class, forVariable(variable));
    }

    public QSysMenuEntity(Path<? extends SysMenuEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysMenuEntity(PathMetadata metadata) {
        super(SysMenuEntity.class, metadata);
    }

}

