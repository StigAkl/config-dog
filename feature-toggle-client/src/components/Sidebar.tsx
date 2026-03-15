import { Link } from "@tanstack/react-router";
import {
	Bell,
	ChevronDown,
	Flag,
	LayoutDashboard,
	SlidersHorizontal,
	Users,
} from "lucide-react";
import { useState } from "react";

const Sidebar = () => {
	const [menuOpen, setMenuOpen] = useState(false);

	return (
		<aside className="sticky top-0 hidden h-screen w-[260px] shrink-0 border-r border-(--line) bg-(--sand) md:flex md:flex-col">
			<div className="border-b border-(--line) p-4">
				<button
					type="button"
					className="flex w-full items-center justify-between rounded-xl border border-(--chip-line) bg-(--chip-bg) px-3 py-2 text-left transition hover:bg-(--link-bg-hover)"
					onClick={() => setMenuOpen((prev) => !prev)}
					aria-expanded={menuOpen}
				>
					<span className="flex items-center gap-3">
						<span className="grid h-9 w-9 place-items-center rounded-lg bg-(--lagoon-deep) text-white shadow-[0_8px_18px_rgba(45,95,34,0.26)]">
							<Flag size={18} />
						</span>
						<span className="min-w-0">
							<span className="block truncate text-sm font-bold text-sea-ink">ConfigDog</span>
							<span className="block truncate text-xs text-sea-ink-soft">Production</span>
						</span>
					</span>
					<ChevronDown
						size={16}
						className={`text-sea-ink-soft transition-transform ${menuOpen ? "rotate-180" : ""}`}
					/>
				</button>
				{menuOpen ? (
					<div className="mt-2 space-y-1 rounded-xl border border-(--line) bg-(--surface-strong) p-2">
						<button
							type="button"
							className="w-full rounded-lg px-2 py-1.5 text-left text-sm font-semibold text-sea-ink hover:bg-(--link-bg-hover)"
						>
							Production
						</button>
						<button
							type="button"
							className="w-full rounded-lg px-2 py-1.5 text-left text-sm text-sea-ink-soft hover:bg-(--link-bg-hover)"
						>
							Staging
						</button>
						<button
							type="button"
							className="w-full rounded-lg px-2 py-1.5 text-left text-sm text-sea-ink-soft hover:bg-(--link-bg-hover)"
						>
							Development
						</button>
					</div>
				) : null}
			</div>

			<nav className="flex-1 p-3">
				<ul className="space-y-1">
					<li>
						<Link
							to="/"
							className="inline-flex w-full items-center gap-2 rounded-lg px-3 py-2 text-sm font-semibold text-sea-ink no-underline transition hover:bg-(--link-bg-hover)"
							activeProps={{ className: "inline-flex w-full items-center gap-2 rounded-lg px-3 py-2 text-sm font-semibold text-white no-underline bg-(--lagoon-deep)" }}
						>
							<LayoutDashboard size={16} />
							Dashboard
						</Link>
					</li>
					<li>
						<Link
							to="/about"
							className="inline-flex w-full items-center gap-2 rounded-lg px-3 py-2 text-sm font-semibold text-sea-ink no-underline transition hover:bg-(--link-bg-hover)"
							activeProps={{ className: "inline-flex w-full items-center gap-2 rounded-lg px-3 py-2 text-sm font-semibold text-white no-underline bg-(--lagoon-deep)" }}
						>
							<SlidersHorizontal size={16} />
							Feature Flags
						</Link>
					</li>
				</ul>
			</nav>

			<div className="border-t border-(--line) p-3">
				<button
					type="button"
					className="mb-1 inline-flex w-full items-center gap-2 rounded-lg px-3 py-2 text-sm text-sea-ink-soft transition hover:bg-(--link-bg-hover)"
				>
					<Users size={16} />
					Team
				</button>
				<button
					type="button"
					className="inline-flex w-full items-center gap-2 rounded-lg px-3 py-2 text-sm text-sea-ink-soft transition hover:bg-(--link-bg-hover)"
				>
					<Bell size={16} />
					Notifications
				</button>
			</div>
		</aside>
	);
};

export default Sidebar;
