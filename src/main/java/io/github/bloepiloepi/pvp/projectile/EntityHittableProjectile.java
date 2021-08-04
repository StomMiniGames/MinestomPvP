package io.github.bloepiloepi.pvp.projectile;

import net.minestom.server.entity.Entity;
import net.minestom.server.entity.EntityProjectile;
import net.minestom.server.entity.EntityType;
import net.minestom.server.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class EntityHittableProjectile extends EntityProjectile {
	private boolean beforeHitCalled = false;
	
	public EntityHittableProjectile(@Nullable Entity shooter, @NotNull EntityType entityType) {
		super(shooter, entityType);
	}
	
	public boolean shouldCallHit() {
		return !beforeHitCalled;
	}
	
	public void setHitCalled(boolean beforeHitCalled) {
		this.beforeHitCalled = beforeHitCalled;
	}
	
	public void onHit(@Nullable Entity entity) {
	}
	
	@Override
	public void onStuck() {
		remove();
	}
	
	public abstract void setItem(@NotNull ItemStack item);
}