package org.openstack4j.openstack.compute.internal.ext;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.openstack4j.api.compute.ext.HypervisorService;
import org.openstack4j.model.compute.ext.Hypervisor;
import org.openstack4j.model.compute.ext.HypervisorStatistics;
import org.openstack4j.openstack.compute.domain.ext.ExtHypervisor;
import org.openstack4j.openstack.compute.domain.ext.ExtHypervisor.Hypervisors;
import org.openstack4j.openstack.compute.domain.ext.ExtHypervisorStatistics;
import org.openstack4j.openstack.compute.internal.BaseComputeServices;

/**
 * Implementation for the OSHypervisors. 
 * 
 */
public class HypervisorServiceImpl extends BaseComputeServices implements HypervisorService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<? extends Hypervisor> list() {
		return get(Hypervisors.class, "/os-hypervisors/detail").execute().getList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HypervisorStatistics statistics() {
		return get(ExtHypervisorStatistics.class, "/os-hypervisors/statistics").execute();
	}
	
	/**
	 * <p>Description:Get the specified Hypervisor by ID</p>
	 * <p>Author:Wang Ting/王婷</p>
	 * @Title: get
	 * @param hypervisorId
	 * @return
	 * @see org.openstack4j.api.compute.ext.HypervisorService#get(java.lang.String)
	 */
	@Override
	public Hypervisor get(String hypervisorId) {
		checkNotNull(hypervisorId);
		return get(ExtHypervisor.class,uri("/os-hypervisors/%s",hypervisorId)).execute();
	}
}
